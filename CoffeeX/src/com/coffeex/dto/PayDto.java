package com.coffeex.dto;

public class PayDto {

	int paystaffid;
	String paydate;
	int payamount;
	int payincentive;
	
	public PayDto() {
		
	}

	public int getPaystaffid() {
		return paystaffid;
	}

	public void setPaystaffid(int paystaffid) {
		this.paystaffid = paystaffid;
	}

	public String getPaydate() {
		return paydate;
	}

	public void setPaydate(String paydate) {
		this.paydate = paydate;
	}

	public int getPayamount() {
		return payamount;
	}

	public void setPayamount(int payamount) {
		this.payamount = payamount;
	}

	public int getPayincentive() {
		return payincentive;
	}

	public void setPayincentive(int incentive) {
		this.payincentive = incentive;
	}

}
