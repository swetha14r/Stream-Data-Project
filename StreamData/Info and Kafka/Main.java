package com.delivery.data;
import static com.delivery.data.GenerateRandomInfo.generateDeliveryTime;

import static com.delivery.data.GenerateRandomInfo.generateOrderTime;
import static com.delivery.data.GenerateRandomInfo.randomLonLat;
import static com.delivery.data.GenerateRandomInfo.generateBooleanData;
import static com.delivery.data.GenerateRandomInfo.generateRandomOrderId;
import static com.delivery.data.GenerateRandomInfo.generateRandomRestaurantId;
import static com.delivery.data.GenerateRandomInfo.generateRandomDriverId;
import static com.delivery.data.GenerateRandomInfo.generateRandomModeOfPayment;
import static com.delivery.data.GenerateRandomInfo.generatePrice;
import static com.delivery.data.GenerateRandomInfo.generateTip;
import static com.delivery.data.GenerateRandomInfo.generateRandomNoOfItems;
import static com.delivery.data.GenerateRandomInfo.generateItemsList;

import java.time.LocalTime;
import java.util.*;
public class Main {
	public static void main(String[] args) throws InterruptedException
	{
		String[] items = { "Idli", "Dosa", "Pizza", "Pasta", "French Fries", "Muffins", "Brownies", "Naan",
                "Noodles", "Paneer Butter Masala", "Aloo Paratha", "Fried Rice" ,"Waffles","Momo","Burger","Taco"};
    while(true)
    {
        int records = new Random().nextInt(15);
        for (int i = 1; i <= records; i++)
        {
            DeliveryInfo deliveryinfo=new DeliveryInfo();
            deliveryinfo.setPrice(generatePrice(25,250));
            double p=deliveryinfo.getPrice();
            deliveryinfo.setTip(generateTip(p));
            int no_of_items=generateRandomNoOfItems(items);
            deliveryinfo.setItems(generateItemsList(no_of_items,items));
            deliveryinfo.setModeOfPayment(generateRandomModeOfPayment());
            deliveryinfo.setOrderID(generateRandomOrderId());
            deliveryinfo.setRestaurantID(generateRandomRestaurantId());
            deliveryinfo.setDriverID(generateRandomDriverId());
            deliveryinfo.setContactlessDelivery(generateBooleanData());
            Map<String, String> jw = randomLonLat(10, 20, 76, 80);
			deliveryinfo.setRestLoc(new Location(Double.parseDouble(jw.get("J")), Double.parseDouble(jw.get("W"))));
            Double lat = Double.parseDouble(jw.get("W"));
            Double lon = Double.parseDouble(jw.get("J"));
            Map<String, String> jw1 = randomLonLat(lon - 0.05, lon + 0.05, lat - 0.05, lat + 0.05);
            deliveryinfo.setCustLoc(new Location(Double.parseDouble(jw1.get("J")), Double.parseDouble(jw1.get("W"))));

            Random generator = new Random();
            LocalTime orderTime = generateOrderTime(generator);
            deliveryinfo.setOrderTime(orderTime);
            deliveryinfo.setDeliveryTime(generateDeliveryTime(orderTime));
            //System.out.println(deliveryinfo);
            SimpleKafkaProducer.sendDataToKafkaMultipleBroker(deliveryinfo.toString(),"testingfooddelivery",deliveryinfo.getModeOfPayment());
        }
        //System.out.println("Written " + records + " to Kafka.");
		Thread.sleep(3000);
    }
	}
	
}