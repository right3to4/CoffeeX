package com.coffeex.dto;

public class MenuViewDto {
	int menuid;
	String category;
	String menuname;
	int price;
	String createdate;
	String updatedate;
	String info;
	String photo;
	String deletedate;
	String shopid;

	public MenuViewDto(int menuid, String category, String menuname, int price, String createdate, String updatedate) {
		super();
		this.menuid = menuid;
		this.category = category;
		this.menuname = menuname;
		this.price = price;
		this.createdate = createdate;
		this.updatedate = updatedate;
	}

	public MenuViewDto() {

	}

	public MenuViewDto(String menuname, int price) {
		super();
		this.menuname = menuname;
		this.price = price;
	}

	public MenuViewDto(String menuname, String info, int price) {
		super();
		this.menuname = menuname;
		this.info = info;
		this.price = price;
	}

	public MenuViewDto(String menuname, int price, String photo) {
		super();
		this.menuname = menuname;
		this.price = price;
		this.photo = photo;
	}

	public int getMenuid() {
		return menuid;
	}

	public void setMenuid(int menuid) {
		this.menuid = menuid;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getDeletedate() {
		return deletedate;
	}

	public void setDeletedate(String deletedate) {
		this.deletedate = deletedate;
	}

	public String getShopid() {
		return shopid;
	}

	public void setShopid(String shopid) {
		this.shopid = shopid;
	}

}
