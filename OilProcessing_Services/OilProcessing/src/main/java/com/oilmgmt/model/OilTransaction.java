package com.oilmgmt.model;

public class OilTransaction {

	int quantity;
	String tradeType;	// Buy or Sell
	double price;

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "OilTransaction [quantity=" + quantity + ", tradeType=" + tradeType + ", price=" + price + "]";
	}
}
