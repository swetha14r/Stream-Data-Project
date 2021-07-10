package com.delivery.data;
import com.google.gson.Gson;

public class DeliveryInfo {
private Orders orders;
private String orderID,restaurantID,vehicleID, driverName;
private boolean contactlessDelivery;
private Location restLoc;
private Location custLoc;

public DeliveryInfo(Orders orders, String orderID, String restaurantID, String vehicleID, String driverName,
		boolean contactlessDelivery, Location restLoc, Location custLoc) {
	super();
	this.orders = orders;
	this.orderID = orderID;
	this.restaurantID = restaurantID;
	this.vehicleID = vehicleID;
	this.driverName = driverName;
	this.contactlessDelivery = contactlessDelivery;
	this.restLoc = restLoc;
	this.custLoc = custLoc;
}

public Orders getOrders() {
	return orders;
}

public void setOrders(Orders orders) {
	this.orders = orders;
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

public String getVehicleID() {
	return vehicleID;
}

public void setVehicleID(String vehicleID) {
	this.vehicleID = vehicleID;
}

public String getDriverName() {
	return driverName;
}

public void setDriverName(String driverName) {
	this.driverName = driverName;
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

}

class Location {
	private double lat;
	private double lon;

	public Location(double lat, double lon) {
		super();
		this.lat = lat;
		this.lon = lon;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	
	public String toString() {
		Gson gson = new Gson();
		return gson.toJson(this);
	}
}

class Orders {
private double price;
private double tip;
private String[] items;
private String modeOfPayment;
public Orders(double price, double tip,String[] items,String modeOfPayment)
{
	this.price=price;
	this.tip=tip;
	this.items=items;
	this.modeOfPayment=modeOfPayment;
}
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


}

