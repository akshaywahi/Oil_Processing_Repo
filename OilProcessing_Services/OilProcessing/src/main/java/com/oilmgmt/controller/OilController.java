package com.oilmgmt.controller;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.oilmgmt.model.OilPrices;
import com.oilmgmt.model.OilTransaction;
import com.oilmgmt.model.PriceEarningsRatio;
import com.oilmgmt.model.RevenueYield;
import com.oilmgmt.service.OilService;

@RestController
public class OilController {

	@Autowired
	private OilService oilService;

	@RequestMapping(value = "/revenue-yield/oilid/{oilid}/price/{price}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object calculateRevenueYield(@PathVariable String oilid, @PathVariable int price) {
		RevenueYield revYld = oilService.getRevenueYield(oilid, price);
		return revYld;
	}

	@RequestMapping(value = "/price-earnings-ratio/oilid/{oilid}/price/{price}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object calculatePriceEarningsRatio(@PathVariable String oilid, @PathVariable int price) {
		PriceEarningsRatio revYld = oilService.getPriceEarningsRatio(oilid, price);
		return revYld;
	}

	@RequestMapping(value = "/oil-trade", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object processOilTrade(@RequestBody OilTransaction oilTxn) {
		Map<String, String> resultMap = new HashMap<>();
		oilService.saveTransaction(oilTxn);
		resultMap.put("Result", "Transaction processed");
		return resultMap;
	}

	@RequestMapping(value = "/volwtd-oil-price", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Object calculateVolWeightedOilPrice() {
		Map<String, Double> resultMap = new HashMap<>();
		double price = oilService.getVolWtdOilPrice();
		resultMap.put("Volume Weighted Oil Price", price);
		return resultMap;
	}

	@RequestMapping(value = "/inventory-index", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Object calculateInventoryIndex(@RequestBody OilPrices oilPrices) {
		Map<String, Double> resultMap = new HashMap<>();
		double price = oilService.getInventoryIndex(oilPrices.getAac_price(), oilPrices.getRew_price(),
				oilPrices.getBwo_price(), oilPrices.getTim_price(), oilPrices.getQfc_price());
		resultMap.put("Volume Weighted Oil Price", price);
		return resultMap;
	}
}
