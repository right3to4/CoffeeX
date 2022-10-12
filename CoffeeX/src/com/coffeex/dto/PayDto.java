package com.coffeex.dto;

public class PayDto {

	int paystaffid;
	int payamount;
	int payincentive;
	String paydate;

	public PayDto() {

	}

	public PayDto(int paystaffid, int payamount, int payincentive, String paydate) {
		super();
		this.paystaffid = paystaffid;
		this.payamount = payamount;
		this.payincentive = payincentive;
		this.paydate = paydate;
	}

	public PayDto(int payamount, int payincentive, String paydate) {
		super();
		this.payamount = payamount;
		this.payincentive = payincentive;
		this.paydate = paydate;
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
