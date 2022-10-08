package com.coffeex.dto;

public class AddcartDto {

	String custid;
	String mmanageid;
	String addcartdate;
	int addcartquantity;
	
	public AddcartDto() {
		
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getMmanageid() {
		return mmanageid;
	}

	public void setMmanageid(String mmanageid) {
		this.mmanageid = mmanageid;
	}

	public String getAddcartdate() {
		return addcartdate;
	}

	public void setAddcartdate(String adddate) {
		this.addcartdate = adddate;
	}

	public int getAddcartquantity() {
		return addcartquantity;
	}

	public void setAddcartquantity(int quantity) {
		this.addcartquantity = quantity;
	}

}
