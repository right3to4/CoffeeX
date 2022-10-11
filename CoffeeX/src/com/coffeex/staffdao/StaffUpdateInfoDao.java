package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.coffeex.util.DBConnect;

public class StaffUpdateInfoDao {

	// Fields

	int staffid;
	String staffname;
	String staffpw;
	String staffphone;

	// Constructor
	public StaffUpdateInfoDao() {
		// TODO Auto-generated constructor stub
	}

	public StaffUpdateInfoDao(String staffname, String staffpw, String staffphone) {
		super();
		this.staffname = staffname;
		this.staffpw = staffpw;
		this.staffphone = staffphone;
	}

	// Method

	public boolean UpdateAction(String staffid) {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			String query = "update staff set staffname=?, staffpw=?, staffphone=? ";
			String query2 = "where staffid ='" + staffid + "'";

			ps = conn_mysql.prepareStatement(query + query2);
			ps.setString(1, staffname);
			ps.setString(2, staffpw);
			ps.setString(3, staffphone);

			ps.executeUpdate();
			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
