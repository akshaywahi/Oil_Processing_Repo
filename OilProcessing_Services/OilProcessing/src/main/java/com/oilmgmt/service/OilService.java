package com.oilmgmt.service;

import com.oilmgmt.model.OilTransaction;
import com.oilmgmt.model.PriceEarningsRatio;
import com.oilmgmt.model.RevenueYield;

public interface OilService {

	public RevenueYield getRevenueYield(String oil_id, double price);

	public PriceEarningsRatio getPriceEarningsRatio(String oilId, double price);

	public void saveTransaction(OilTransaction oilTxn);

	public double getVolWtdOilPrice();

	public double getInventoryIndex(double p1, double p2, double p3, double p4, double p5);

}
