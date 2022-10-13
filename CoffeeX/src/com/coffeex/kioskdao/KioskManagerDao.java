package com.coffeex.kioskdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.coffeex.util.DBConnect;

public class KioskManagerDao {

	public KioskManagerDao() {
		
	}
	
	public boolean loginCheck(String staffid) {
		PreparedStatement ps = null;
		int wkStaffid = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "select count(*) from staff ";
			String whereStatement1 = " where staffid='" + staffid + "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);

			if (rs.next()) {
				wkStaffid = rs.getInt(1);
			}

			conn_mysql.close();
			
			if (wkStaffid==0) {
				return false;
			} else {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean checkShopName(String shopname) {
		PreparedStatement ps = null;
		int wkShopid = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "select count(*) from shop ";
			String whereStatement1 = " where shopid='" + shopname + "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);

			if (rs.next()) {
				wkShopid = rs.getInt(1);
			}

			conn_mysql.close();
			
			if (wkShopid==0) {
				return false;
			} else {
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public String checkShopName(int staffid) {
		PreparedStatement ps = null;
		String wkShopid = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "select belongshopid from belong ";
			String whereStatement1 = " where belongstaffid='" + staffid + "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);

			if (rs.next()) {
				wkShopid = rs.getString(1);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return wkShopid;
	}
}
