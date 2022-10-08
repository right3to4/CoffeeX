package com.coffeex.dto;

public class CustomerDto {
	int custid;
	String custname;
	String custphone;
	String custpw;
	int custpoint;
	String custsigndate;
	String custupdatedate;
	String custdeletedate;
	
	public CustomerDto() {
		
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustname() {
		return custname;
	}

	public void setCustname(String custname) {
		this.custname = custname;
	}

	public String getCustphone() {
		return custphone;
	}

	public void setCustphone(String custphone) {
		this.custphone = custphone;
	}

	public String getCustpw() {
		return custpw;
	}

	public void setCustpw(String custpw) {
		this.custpw = custpw;
	}

	public int getCustpoint() {
		return custpoint;
	}

	public void setCustpoint(int point) {
		this.custpoint = point;
	}

	public String getCustsigndate() {
		return custsigndate;
	}

	public void setCustsigndate(String custsigndate) {
		this.custsigndate = custsigndate;
	}

	public String getCustupdatedate() {
		return custupdatedate;
	}

	public void setCustupdatedate(String custupdatedate) {
		this.custupdatedate = custupdatedate;
	}

	public String getCustdeletedate() {
		return custdeletedate;
	}

	public void setCustdeletedate(String custdeletedate) {
		this.custdeletedate = custdeletedate;
	}

}
