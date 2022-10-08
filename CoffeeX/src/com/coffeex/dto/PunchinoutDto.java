package com.coffeex.dto;

public class PunchinoutDto {

	int punchshopid;
	int punchstaffid;
	String punchintime;
	String punchouttime;
	
	public PunchinoutDto() {
		
	}

	public int getPunchshopid() {
		return punchshopid;
	}

	public void setPunchshopid(int punchshopid) {
		this.punchshopid = punchshopid;
	}

	public int getPunchstaffid() {
		return punchstaffid;
	}

	public void setPunchstaffid(int punchstaffid) {
		this.punchstaffid = punchstaffid;
	}

	public String getPunchintime() {
		return punchintime;
	}

	public void setPunchintime(String punchintime) {
		this.punchintime = punchintime;
	}

	public String getPunchouttime() {
		return punchouttime;
	}

	public void setPunchouttime(String punchouttime) {
		this.punchouttime = punchouttime;
	}

}
