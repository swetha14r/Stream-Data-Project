package com.delivery.data;
import java.time.LocalTime;
import com.google.gson.Gson;
public class DeliveryInfo {
	public double price;
    public double tip;
    public String[] items;
    public String modeOfPayment;
    public String orderID, restaurantID, driverID;
    public boolean contactlessDelivery;
    public Location restLoc;
    public Location custLoc;
    public LocalTime orderTime;
    public LocalTime deliveredTime;


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTip() {
        return tip;
    }

    public void setTip(double tip) {
        this.tip = tip;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public String getModeOfPayment() {
        return modeOfPayment;
    }

    public void setModeOfPayment(String modeOfPayment) {
        this.modeOfPayment = modeOfPayment;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }


    public String getDriverID() {
        return driverID;
    }

    public void setDriverID(String driverID) {
        this.driverID = driverID;
    }

    public boolean isContactlessDelivery() {
        return contactlessDelivery;
    }

    public void setContactlessDelivery(boolean contactlessDelivery) {
        this.contactlessDelivery = contactlessDelivery;
    }

    public Location getRestLoc() {
        return restLoc;
    }

    public void setRestLoc(Location restLoc) {
        this.restLoc = restLoc;
    }

    public Location getCustLoc() {
        return custLoc;
    }

    public void setCustLoc(Location custLoc) {
        this.custLoc = custLoc;
    }


    public void setOrderTime(LocalTime orderTime) {
        this.orderTime = orderTime;
    }

    public LocalTime getOrderTime() {
        return orderTime;
    }

    public void setDeliveryTime(LocalTime deliveredTime) {
        this.deliveredTime = deliveredTime;
    }

    public LocalTime getDeliveryTime() {
        return deliveredTime;
    }
    
    public String toString() {
    	Gson gson = new Gson();
		return gson.toJson(this);
    }
}
