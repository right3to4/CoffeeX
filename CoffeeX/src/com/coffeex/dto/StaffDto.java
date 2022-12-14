package com.coffeex.dto;

public class StaffDto {

	int staffid;
	String staffname;
	String staffpw;
	String staffphone;
	int staffhourlywage;
	String staffinitdate;
	String staffdeletedate;

	String belog;
	
	String position;
	
	public StaffDto() {

	}
	
	public StaffDto(int staffid, String staffname, String staffphone, int staffhourlywage, String staffinitdate,
			String staffdeletedate, String belog,String position) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffphone = staffphone;
		this.staffhourlywage = staffhourlywage;
		this.staffinitdate = staffinitdate;
		this.staffdeletedate = staffdeletedate;
		this.belog = belog;
		this.position = position;
	}
	
	public StaffDto(int staffid, String staffname, String staffphone, int staffhourlywage, String staffinitdate,
			String staffdeletedate, String belog) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffphone = staffphone;
		this.staffhourlywage = staffhourlywage;
		this.staffinitdate = staffinitdate;
		this.staffdeletedate = staffdeletedate;
		this.belog = belog;
	}

	public StaffDto(int staffid, String staffname, String staffphone, String staffinitdate, String staffdeletedate) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffphone = staffphone;
		this.staffinitdate = staffinitdate;
		this.staffdeletedate = staffdeletedate;
	}

	public StaffDto(int staffid, String staffname, String staffphone, String staffinitdate) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffphone = staffphone;
		this.staffinitdate = staffinitdate;
	}

	public StaffDto(int staffid, String staffname, String staffphone) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffphone = staffphone;
	}

	public StaffDto(String staffname, String staffpw, String staffphone) {
		super();
		this.staffname = staffname;
		this.staffpw = staffpw;
		this.staffphone = staffphone;
	}

	public int getStaffid() {
		return staffid;
	}

	public void setStaffid(int staffid) {
		this.staffid = staffid;
	}

	public String getStaffname() {
		return staffname;
	}

	public void setStaffname(String staffname) {
		this.staffname = staffname;
	}

	public String getStaffpw() {
		return staffpw;
	}

	public void setStaffpw(String staffpw) {
		this.staffpw = staffpw;
	}

	public String getStaffphone() {
		return staffphone;
	}

	public void setStaffphone(String staffphone) {
		this.staffphone = staffphone;
	}

	public int getStaffhourlywage() {
		return staffhourlywage;
	}

	public void setStaffhourlywage(int staffhourlywage) {
		this.staffhourlywage = staffhourlywage;
	}

	public String getStaffinitdate() {
		return staffinitdate;
	}

	public void setStaffinitdate(String staffinitdate) {
		this.staffinitdate = staffinitdate;
	}

	public String getStaffdeletedate() {
		return staffdeletedate;
	}

	public void setStaffdeletedate(String staffdeletedate) {
		this.staffdeletedate = staffdeletedate;
	}

	public String getBelog() {
		return belog;
	}

	public void setBelog(String belog) {
		this.belog = belog;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	
	
}
