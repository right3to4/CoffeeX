package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.ShopDto;
import com.coffeex.util.DBConnect;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;


public class ChefManageShopDao {
	
	String shopid;
	String shopaddress;
	String shopphone;
	String shopphotoname;
	FileInputStream shopphoto;
	String openinghours;
	String openingdate;
	String deletedate;
	
	String conname;
	String condata;
	
	public ChefManageShopDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ChefManageShopDao(String conname, String condata) {
		super();
		this.conname = conname;
		this.condata = condata;
	}


	public ChefManageShopDao(String shopid, String shopaddress, String shopphone, String shopphotoname, FileInputStream shopphoto, String openinghours) {
		super();
		this.shopid = shopid;
		this.shopaddress = shopaddress;
		this.shopphone = shopphone;
		this.shopphotoname = shopphotoname;
		this.shopphoto = shopphoto;
		
		this.openinghours = openinghours;
	}


	public ChefManageShopDao(String shopid) {
		super();
		this.shopid = shopid;
	}


	public boolean insertAction() {
		
		PreparedStatement ps = null;
		try {
			//sql접속
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			//쿼리문작성
			String query = "insert into shop (shopid, shopaddress, shopphone, shopphotoname, shopphoto, openinghours, openingdate) ";
			String query1 = "values(?,?,?,?,?,?,now())";
			//데이터입력
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setString(1, shopid.trim());
			ps.setString(2, shopaddress.trim());
			ps.setString(3, shopphone.trim());
			ps.setString(4, shopphotoname.trim());
			ps.setBinaryStream(5, shopphoto);
			ps.setString(6, openinghours.trim());
			//실행
			ps.executeUpdate();
			
			//데이터베이스 연결종료
			conn_mysql.close();
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean deleteAction(int shopid) {
	PreparedStatement ps = null;
	try {
		//sql접속
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
		Statement stmt_mysql = conn_mysql.createStatement();
		//쿼리문작성
		String query = "update shop set deletedate = now() where shopid = ? ";
		//데이터입력
		ps = conn_mysql.prepareStatement(query);
	
		ps.setInt(1, shopid);
		//실행
		ps.executeUpdate();
		
		//데이터베이스 연결종료
		conn_mysql.close();	
		
	}catch(Exception e) {
		e.printStackTrace();
		return false;
		}
	return true;
	}
	
	public ArrayList<ShopDto> selectList(){
		
		ArrayList<ShopDto> BeanList = new ArrayList<ShopDto>();
		
		String whereStatement = "select shopid, shopaddress, shopphone, shopphotoname, shopphoto from shop ";
		//String whereStatement2 = "where "+ conname + " like '%" + condata +"%' and deletedate is null";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);
			//ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			while(rs.next()) {
				
				String wkshopid = rs.getString(1);
				String wkshopaddress = rs.getString(2);
				String wkshopphone = rs.getString(3);
				String wkshopphotoname = rs.getString(4);
				
				// File
				File file = new File("./" + wkshopphotoname);
				FileOutputStream output = new FileOutputStream(wkshopphotoname);
				InputStream input = rs.getBinaryStream(5);
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
								
				ShopDto shopdto = new ShopDto(wkshopid, wkshopaddress, wkshopphone, wkshopphotoname);
				BeanList.add(shopdto);
			}
		
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		return BeanList;
	}
	/*
	public StaffDto tableClick() {
		
		StaffDto dto = null;
		
		String whereStatement = "select staffid, staffname, staffphone from staff ";
		String whereStatement2 = "where staffid = "+ staffid;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			while(rs.next()) {
				
				int wkstaffid = rs.getInt(1);
				String wkstaffname = rs.getString(2);
				String wkstaffphone = rs.getString(3);
				
				dto = new StaffDto(wkstaffid, wkstaffname, wkstaffphone);
				
			}
				
			conn_mysql.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}

	public boolean idCheck(String staffid) {
		PreparedStatement ps = null;
		int count = 0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String query = "select count(staffid) from staff where staffid = ";
			String query1 = "'" + staffid + "'";
			ps = conn_mysql.prepareStatement(query + query1);
			ResultSet rs = stmt_mysql.executeQuery(query + query1);
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (Exception e) {
		}
		if (count == 0) {
			return true;
		} else {
			return false;
		}
	}
*/
	
}

