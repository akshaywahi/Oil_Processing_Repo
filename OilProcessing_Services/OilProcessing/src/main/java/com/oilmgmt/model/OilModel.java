package com.oilmgmt.model;

public class OilModel {
	
	String oilId;	
	double price;
	
	public String getOilId() {
		return oilId;
	}

	public void setOil_id(String oil_id) {
		this.oilId = oil_id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "OilModel [oil_id=" + oilId + ", price=" + price + "]";
	}
}
