package com.oilmgmt.service.impl;

import java.util.Map;
import java.util.TreeMap;

import org.springframework.stereotype.Service;

import com.oilmgmt.model.OilTransaction;
import com.oilmgmt.model.PriceEarningsRatio;
import com.oilmgmt.model.RevenueYield;
import com.oilmgmt.service.OilService;
import com.oilmgmt.util.DecreasingOrderComparator;

@Service
public class OilServiceImpl implements OilService {
	
	public static Map<Long, OilTransaction> txnMap = new TreeMap<>(new DecreasingOrderComparator());

	@Override
	public RevenueYield getRevenueYield(String oilId, double price) {
		RevenueYield resultantYield = new RevenueYield();
		resultantYield.setStandard(getFixedRevenue(oilId) / price);
		
		if(oilId.equalsIgnoreCase("TIM")) {
			resultantYield.setPremium((double)(7 * 111) / (price*100));
		}
		
		return resultantYield;
	}
	
	@Override
	public PriceEarningsRatio getPriceEarningsRatio(String oilId, double price) {
		PriceEarningsRatio resultantRatio = new PriceEarningsRatio();
		resultantRatio.setPriceEarningsRatio(price / getFixedRevenue(oilId)); 
		return resultantRatio;
	}

	private double getFixedRevenue(String oilId) {
		double fixedRevenue;
		switch (oilId) {
		case "AAC":
			fixedRevenue = 1d;
			break;
		case "REW":
			fixedRevenue = 7d;
			break;
		case "BWO":
			fixedRevenue = 17d;
			break;
		case "TIM":
			fixedRevenue = 5d;
			break;
		case "QFC":
			fixedRevenue = 22d;
			break;
		default:
			fixedRevenue = 0d;
		}
		
		return fixedRevenue;
	}

	@Override
	public void saveTransaction(OilTransaction oilTxn) {
		txnMap.put(System.currentTimeMillis(), oilTxn);
	}

	@Override
	public double getVolWtdOilPrice() {
		long totalQty = 0;
		double totalPrice= 0;
		OilTransaction currRecord = null;
		long curTime = System.currentTimeMillis();
		for(Map.Entry<Long, OilTransaction> entry : txnMap.entrySet()) {
			if(curTime - entry.getKey() <= 1800000) {	// Within 30 minutes
				currRecord = entry.getValue();
				totalPrice += (currRecord.getPrice() * currRecord.getQuantity());
				totalQty += currRecord.getQuantity();
			}
		}
		
		return totalPrice / totalQty;
	}

	@Override
	public double getInventoryIndex(double p1, double p2, double p3, double p4, double p5) {
		return Math.pow((p1*p2*p3*p4*p5), 1.0/5);
	}

}
