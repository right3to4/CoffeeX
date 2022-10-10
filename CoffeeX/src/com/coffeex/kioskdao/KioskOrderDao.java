package com.coffeex.kioskdao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.MenuViewDto;
import com.coffeex.dto.ViewCartDto;
import com.coffeex.util.DBConnect;

public class KioskOrderDao {

	public KioskOrderDao() {

	}

	public ArrayList<ViewCartDto> ShowCart(String custid) {

		ArrayList<ViewCartDto> dtoList = new ArrayList<ViewCartDto>();
		String whereStatement = "select menu, price, quantity, addoption from viewcart ";
		String whereStatement2 = "where custid='" + custid + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {
				String wkName = rs.getString(1);
				int wkPrice = rs.getInt(2);
				int wkQuantity = rs.getInt(3);
				String wkOption = rs.getString(4);
				ViewCartDto dto = new ViewCartDto(wkName, wkPrice, wkQuantity, wkOption);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (

		Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
	
	public void emptyCart(String custid) {

		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "delete from addcart where ";
			String whereStatement1 = "custid='" + custid + "'";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);
			ps.executeUpdate();

			// 데이터베이스 연결종료
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkCart(String custid, String menuname, String option) {
		PreparedStatement ps = null;
		int wkCount=1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "select count(*) from viewcart where ";
			String whereStatement2 = "custid='" + custid + "' and menu='" + menuname + "' and addoption='" + option + "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement2);
			
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			while (rs.next()) {
				wkCount = rs.getInt(1);
			}
			conn_mysql.close();
			
			if (wkCount==1) {
				return true;
			} else {
				return false;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void AddCart(String mmanageid, String custid, int addcartquantity, String addcartoption) {

		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "insert into addcart (mmanegeid, custid, addcartdate, addcartquantity, addcartoption) ";
			String whereStatement1 = "values(?,?,curdate(),?,?) ";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);
			ps.setString(1, mmanageid);
			ps.setString(2, custid);
			ps.setInt(3, addcartquantity);
			ps.setString(4, addcartoption);
			// 실행
			ps.executeUpdate();

			// 데이터베이스 연결종료
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void AddQuantity(String mmanageid, String custid, String addcartoption, int quantity) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "update addcart set addcartquantity=addcartquantity+" + quantity;
			String whereStatement1 = " where mmanegeid='" + mmanageid + "' and custid='" + custid + "' and addcartoption='" + addcartoption + "';";
			
			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
