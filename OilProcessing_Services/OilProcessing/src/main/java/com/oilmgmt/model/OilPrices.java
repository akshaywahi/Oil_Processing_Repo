package com.oilmgmt.model;

public class OilPrices {	

	double aac_price;
	double rew_price;
	double bwo_price;
	double tim_price;
	double qfc_price;

	public double getAac_price() {
		return aac_price;
	}

	public void setAac_price(double aac_price) {
		this.aac_price = aac_price;
	}

	public double getRew_price() {
		return rew_price;
	}

	public void setRew_price(double rew_price) {
		this.rew_price = rew_price;
	}

	public double getBwo_price() {
		return bwo_price;
	}

	public void setBwo_price(double bwo_price) {
		this.bwo_price = bwo_price;
	}

	public double getTim_price() {
		return tim_price;
	}

	public void setTim_price(double tim_price) {
		this.tim_price = tim_price;
	}

	public double getQfc_price() {
		return qfc_price;
	}

	public void setQfc_price(double qfc_price) {
		this.qfc_price = qfc_price;
	}

	@Override
	public String toString() {
		return "OilPrices [aac_price=" + aac_price + ", rew_price=" + rew_price + ", bwo_price=" + bwo_price
				+ ", tim_price=" + tim_price + ", qfc_price=" + qfc_price + "]";
	}

}
