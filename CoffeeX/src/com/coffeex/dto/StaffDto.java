package com.coffeex.dto;

public class StaffDto {

	int staffid;
	String staffname;
	String staffpw;
	String staffphone;
	int staffhourlywage;
	String staffinitdate;
	String staffdeletedate;

	public StaffDto() {

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

}
