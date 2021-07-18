package com.spark;
import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.get_json_object;

import java.util.concurrent.TimeoutException;

import org.apache.spark.SparkConf;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.streaming.StreamingQueryException;
public class StructuredStreaming {
	public static void main(String[] args) throws InterruptedException, StreamingQueryException, TimeoutException {
		SparkConf conf = new SparkConf().setAppName("StructuredStreaming").setMaster("local[*]");

		SparkSession spark = SparkSession.builder().config(conf).getOrCreate();

		Dataset<Row> orderInfoDf = spark.readStream()
				.format("kafka")
				.option("kafka.bootstrap.servers", "localhost:9092,localhost:9093")
				.option("subscribe", "food-info-kafka")
				.load()
				.selectExpr("CAST(key AS STRING)", "CAST(value AS STRING)")
				.select(get_json_object(col("value"), "$.orderID").alias("orderID"),
						get_json_object(col("value"), "$.restaurantID").alias("restaurantID"),
						get_json_object(col("value"), "$.driverID").alias("driverID"),
						get_json_object(col("value"), "$.price").alias("price"),
						get_json_object(col("value"), "$.tip").alias("tip"),
						get_json_object(col("value"), "$.modeOfPayment").alias("modeOfPayment"),
						get_json_object(col("value"), "$.contactlessDelivery").alias("contactlessDelivery"),
						get_json_object(col("value"), "$.orderTime").alias("orderedTime"),
						get_json_object(col("value"), "$.deliveredTime").alias("ETA"),
						get_json_object(col("value"), "$.custLoc.lat").alias("latitude(customer)"),
						get_json_object(col("value"), "$.custLoc.lon").alias("longitude(customer)"),
						get_json_object(col("value"), "$.restLoc.lat").alias("latitude(restaurant)"),
						get_json_object(col("value"), "$.restLoc.lon").alias("longitude(restaurant)"));

		Dataset<Row> paymentInfo = orderInfoDf.filter(col("modeOfPayment").equalTo("Card"));
		paymentInfo.writeStream().format("json")
				.option("checkpointLocation",
						"/home/swetha/eclipse-workspace/FoodDeliverySystem_1/check-point")
				.option("path", "/home/swetha/eclipse-workspace/FoodDeliverySystem_1/card").start()
				.awaitTermination();

	}
}
