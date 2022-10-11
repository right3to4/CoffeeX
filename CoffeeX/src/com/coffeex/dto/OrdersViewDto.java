package com.coffeex.dto;

public class OrdersViewDto {

	int orderid;
	int staffid;
	String orderyear;
	String ordermonth;
	String menuname;
	String orderstatus;
	int quantity;
	int price;
	String ordersoptions;

	public OrdersViewDto(String orderyear, String ordermonth, int price) {
		super();
		this.orderyear = orderyear;
		this.ordermonth = ordermonth;
		this.price = price;
	}

	public OrdersViewDto(int orderid, String menuname, int quantity, String ordersoptions) {
		super();
		this.orderid = orderid;
		this.menuname = menuname;
		this.quantity = quantity;
		this.ordersoptions = ordersoptions;
	}

	public OrdersViewDto(String menuname, int quantity, int price) {
		super();
		this.menuname = menuname;
		this.quantity = quantity;
		this.price = price;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public String getOrderyear() {
		return orderyear;
	}

	public void setOrderyear(String orderyear) {
		this.orderyear = orderyear;
	}

	public String getOrdermonth() {
		return ordermonth;
	}

	public void setOrdermonth(String ordermonth) {
		this.ordermonth = ordermonth;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getOrdersoptions() {
		return ordersoptions;
	}

	public void setOrdersoptions(String ordersoptions) {
		this.ordersoptions = ordersoptions;
	}
}
