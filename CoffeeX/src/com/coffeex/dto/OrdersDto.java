package com.coffeex.dto;

public class OrdersDto {

	int ordersid;
	int ordersstaffid;
	String ordersmmanageid;
	String ordersshopid;
	String orderscustid;
	String ordersstatus;
	int ordersquantity;
	String ordersoption;
	String orderspaymentoptions;
	int orderssaleprice;
	int ordersplaceselect;
	String ordersdate;
	int ordersrevervationtime;
	
	public OrdersDto() {

	}

	public OrdersDto(int ordersstaffid, String ordersmmanageid, int ordersquantity, int orderssaleprice,
			String ordersdate) {
		super();
		this.ordersstaffid = ordersstaffid;
		this.ordersmmanageid = ordersmmanageid;
		this.ordersquantity = ordersquantity;
		this.orderssaleprice = orderssaleprice;
		this.ordersdate = ordersdate;
	}

	public int getOrdersid() {
		return ordersid;
	}

	public void setOrderid(int ordersid) {
		this.ordersid = ordersid;
	}

	public int getOrdersstaffid() {
		return ordersstaffid;
	}

	public void setOrderstaffid(int ordersstaffid) {
		this.ordersstaffid = ordersstaffid;
	}

	public String getOrdersmmanageid() {
		return ordersmmanageid;
	}

	public void setOrdersmmanageid(String ordersmmanageid) {
		this.ordersmmanageid = ordersmmanageid;
	}

	public String getOrdersshopid() {
		return ordersshopid;
	}

	public void setOrdersshopid(String ordersshopid) {
		this.ordersshopid = ordersshopid;
	}

	public String getOrderscustid() {
		return orderscustid;
	}

	public void setOrderscustid(String ordercustomerid) {
		this.orderscustid = ordercustomerid;
	}

	public String getOrdersstatus() {
		return ordersstatus;
	}

	public void setOrdersstatus(String ordersstatus) {
		this.ordersstatus = ordersstatus;
	}

	public int getOrdersquantity() {
		return ordersquantity;
	}

	public void setOrdersquantity(int ordersquantity) {
		this.ordersquantity = ordersquantity;
	}

	public String getOrdersoption() {
		return ordersoption;
	}

	public void setOrdersoption(String ordersoption) {
		this.ordersoption = ordersoption;
	}

	public String getOrderspaymentoptions() {
		return orderspaymentoptions;
	}

	public void setOrderspaymentoptions(String orderspaymentoptions) {
		this.orderspaymentoptions = orderspaymentoptions;
	}

	public int getOrderssaleprice() {
		return orderssaleprice;
	}

	public void setOrderssaleprice(int orderssaleprice) {
		this.orderssaleprice = orderssaleprice;
	}

	public int getOrdersplaceselect() {
		return ordersplaceselect;
	}

	public void setOrdersplaceselect(int ordersplaceselect) {
		this.ordersplaceselect = ordersplaceselect;
	}

	public String getOrdersdate() {
		return ordersdate;
	}

	public void setOrdersdate(String orderdate) {
		this.ordersdate = orderdate;
	}

	public int getOrdersrevervationtime() {
		return ordersrevervationtime;
	}

	public void setOrdersrevervationtime(int ordersrevervationtime) {
		this.ordersrevervationtime = ordersrevervationtime;
	}

}
