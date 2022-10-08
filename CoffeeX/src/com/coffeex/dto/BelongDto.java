package com.coffeex.dto;

public class BelongDto {

	int belongshopid;
	int belongstaffid;
	String belongdate;
	
	public BelongDto() {
		
	}

	public int getBelongshopid() {
		return belongshopid;
	}

	public void setBelongshopid(int belongshopid) {
		this.belongshopid = belongshopid;
	}

	public int getBelongstaffid() {
		return belongstaffid;
	}

	public void setBelongstaffid(int belongstaffid) {
		this.belongstaffid = belongstaffid;
	}

	public String getBelongdate() {
		return belongdate;
	}

	public void setBelongdate(String belongdate) {
		this.belongdate = belongdate;
	}

}
