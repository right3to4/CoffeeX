package com.coffeex.kioskdao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.coffeex.util.DBConnect;

public class KioskSetOptionDao {

	String mmanageid;
	String custid;
	String addcartdate;
	int addcartquantity;
	String addcartoption;

	public KioskSetOptionDao() {

	}
	
	

	public KioskSetOptionDao(String mmanageid, String custid, int addcartquantity, String addcartoption) {
		super();
		this.mmanageid = mmanageid;
		this.custid = custid;
		this.addcartquantity = addcartquantity;
		this.addcartoption = addcartoption;
	}



	public KioskSetOptionDao(String mmanageid) {
		super();
		this.mmanageid = mmanageid;
	}

	public String getMenuId(String menuname) {
		String whereStatement = "select menuid from menu ";
		String WhereStatement2 = "where menuname='" + menuname + "';";
		String wkMenuID = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + WhereStatement2);

			while (rs.next()) {
				wkMenuID = rs.getString(1);
			}
		} catch (Exception e) {
		}
		return wkMenuID;
	}



}
