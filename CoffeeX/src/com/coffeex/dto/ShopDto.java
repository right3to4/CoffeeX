package com.coffeex.dto;

public class ShopDto {

	String shopid;
	String shopaddress;
	String shopphone;
	String shopphotoname;
	String openinghours;
	String openingdate;
	String closingdate;
	
	public ShopDto(String shopid, String shopaddress, String shopphone, String shopphotoname) {
		super();
		this.shopid = shopid;
		this.shopaddress = shopaddress;
		this.shopphone = shopphone;
		this.shopphotoname = shopphotoname;
	}
	
	public ShopDto(String shopid, String shopaddress, String shopphone, String shopphotoname, String openinghours) {
		super();
		this.shopid = shopid;
		this.shopaddress = shopaddress;
		this.shopphone = shopphone;
		this.shopphotoname = shopphotoname;
		this.openinghours = openinghours;
	}
	
	public ShopDto(String shopid) {
		super();
		this.shopid = shopid;
	}

	public ShopDto() {
		
	}

	public String getShopid() {
		return shopid;
	}

	public String getShopphotoname() {
		return shopphotoname;
	}

	public void setShopphotoname(String shopphotoname) {
		this.shopphotoname = shopphotoname;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

	public String getShopaddress() {
		return shopaddress;
	}

	public void setShopaddress(String shopaddress) {
		this.shopaddress = shopaddress;
	}

	public String getShopphone() {
		return shopphone;
	}

	public void setShopphone(String shopphone) {
		this.shopphone = shopphone;
	}

	public String getOpeninghours() {
		return openinghours;
	}

	public void setOpeninghours(String openinghours) {
		this.openinghours = openinghours;
	}

	public String getOpeningdate() {
		return openingdate;
	}

	public void setOpeningdate(String openingdate) {
		this.openingdate = openingdate;
	}

	public String getClosingdate() {
		return closingdate;
	}

	public void setClosingdate(String closingdate) {
		this.closingdate = closingdate;
	}

}
