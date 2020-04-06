package com.oilmgmt.service.unit;

import org.junit.Assert;
import org.junit.Test;

import com.oilmgmt.model.OilTransaction;
import com.oilmgmt.model.PriceEarningsRatio;
import com.oilmgmt.model.RevenueYield;
import com.oilmgmt.service.impl.OilServiceImpl;

public class OilServiceImplTest {

	OilServiceImpl oilService = new OilServiceImpl();
	
	@Test
	public void testGetRevenueYield() {
		String oilId = "TIM";
		double price = 5d;
		RevenueYield result = oilService.getRevenueYield(oilId, price);
		Assert.assertEquals(1.d, result.getStandard(), 0.0d);
		Assert.assertEquals(1.554d, result.getPremium(), 0.0d);
	}
	
	@Test
	public void testGetPriceEarningsRatio() {
		String oilId = "AAC";
		double price = 5d;
		PriceEarningsRatio result = oilService.getPriceEarningsRatio(oilId, price);
		Assert.assertEquals(5d, result.getPriceEarningsRatio(), 0.0d);
	}
	
	@Test
	public void testGetVolWtdOilPrice() {
		
		OilTransaction oilTxn = new OilTransaction();
		oilTxn.setTradeType("Sell");
		oilTxn.setPrice(2);
		oilTxn.setQuantity(2);
		
		OilTransaction oilTxn2 = new OilTransaction();
		oilTxn2.setTradeType("Buy");
		oilTxn2.setPrice(3);
		oilTxn2.setQuantity(3);
		
		OilServiceImpl.txnMap.put(System.currentTimeMillis()-4, oilTxn);
		OilServiceImpl.txnMap.put(System.currentTimeMillis()-2, oilTxn2);
		
		double result = oilService.getVolWtdOilPrice();
		Assert.assertEquals(2.6d, result, 0.0d);
	}
	
	@Test
	public void testGetInventoryIndex() {
		double invIndex = oilService.getInventoryIndex(9, 3, 9, 1, 1);
		Assert.assertEquals(3d, invIndex, 0.0d);
	}	
}
