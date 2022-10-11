package com.coffeex.dto;

public class OrdersViewDto {

	int orderid;
	String menuname;
	String orderstatus;
	int quantity;
	String ordersoptions;

	public OrdersViewDto(int orderid, String menuname, int quantity, String ordersoptions) {
		super();
		this.orderid = orderid;
		this.menuname = menuname;
		this.quantity = quantity;
		this.ordersoptions = ordersoptions;
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
