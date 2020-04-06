package com.oilmgmt.model;

public class RevenueYield {
	
	double standard;
	double premium;
	
	public double getStandard() {
		return standard;
	}
	public void setStandard(double standard) {
		this.standard = standard;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	
	@Override
	public String toString() {
		return "RevenueYield [standard=" + standard + ", premium=" + premium + "]";
	}
}
