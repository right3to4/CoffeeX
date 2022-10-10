package com.coffeex.dto;

public class ViewCartDto {

	String menu;
	int price;
	int quantity;
	String addoption;

	public ViewCartDto(String menu, int price, int quantity, String addoption) {
		super();
		this.menu = menu;
		this.price = price;
		this.quantity = quantity;
		this.addoption = addoption;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAddoption() {
		return addoption;
	}

	public void setAddoption(String addoption) {
		this.addoption = addoption;
	}

}
