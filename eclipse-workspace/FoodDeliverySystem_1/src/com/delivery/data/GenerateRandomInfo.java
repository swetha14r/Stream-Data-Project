package com.delivery.data;

import java.time.LocalTime;
import java.util.*;
import java.math.BigDecimal;

public class GenerateRandomInfo {

    // order time
    public static LocalTime generateOrderTime(Random generator) {
        LocalTime time = LocalTime.MIN.plusSeconds(generator.nextLong());
        return time;
    }

    // delivery time
    public static LocalTime generateDeliveryTime(LocalTime orderTime) {
        long del = new Random(10).nextInt(55);
        return orderTime.plusMinutes(del);
    }

    // location
    @SuppressWarnings("deprecation")
	public static Map<String, String> randomLonLat(double MinLon, double MaxLon, double MinLat, double MaxLat) {
        BigDecimal db = new BigDecimal(Math.random() * (MaxLon - MinLon) + MinLon);
        String lon = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        db = new BigDecimal(Math.random() * (MaxLat - MinLat) + MinLat);
        String lat = db.setScale(6, BigDecimal.ROUND_HALF_UP).toString();
        Map<String, String> map = new HashMap<String, String>();
        map.put("J", lon);
        map.put("W", lat);
        return map;
    }

    // contactless delivery
    public static boolean generateBooleanData() {
        return new Random().nextBoolean();
    }

    public static String generateRandomOrderId() {
        return UUID.randomUUID().toString();
    }

    public static String generateRandomRestaurantId() {
        return UUID.randomUUID().toString();
    }

    public static String generateRandomDriverId() {
        return UUID.randomUUID().toString();
    }

    public static String generateRandomModeOfPayment() {
        String[] modeOfPayment = { "Cash On Delivery", "Card" };
        return modeOfPayment[new Random().nextInt(modeOfPayment.length)];
    }

    public static double generatePrice(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    public static double generateTip(double Price) {
        double tip = new Random(1).nextInt(20);
        return Price * tip / 100;
    }

        public static int generateRandomNoOfItems(String[] items){
        return new Random(1).nextInt(items.length);
        } 
        public static String[] generateItemsList(int no_of_items,String[] items){
            Set<String> set=new HashSet<String>();
            for (int i = 0; i < no_of_items; i++) {
                set.add(items[new Random().nextInt(items.length)]);
            }
            int n=set.size();
            String arr[] = new String[n];
            arr = set.toArray(arr);
            return arr;
            }
    }