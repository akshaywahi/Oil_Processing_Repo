package com.oilmgmt.model;

public class TradeResult {

	String responseMsg;
	
	public String getResponseMsg() {
		return responseMsg;
	}

	public void setResponseMsg(String responseMsg) {
		this.responseMsg = responseMsg;
	}
	
	@Override
	public String toString() {
		return "TradeResult [responseMsg=" + responseMsg + "]";
	}
}
