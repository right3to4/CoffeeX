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
	public boolean deleteAction(String shopid) {
	PreparedStatement ps = null;
	try {
		//sql접속
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
		Statement stmt_mysql = conn_mysql.createStatement();
		//쿼리문작성
		String query = "update shop set closingdate = now() where shopid = ? ";
		//데이터입력
		ps = conn_mysql.prepareStatement(query);
	
		ps.setString(1, shopid);
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
		
		String whereStatement = "select shopid, shopaddress, shopphone, openinghours, shopphotoname, shopphoto from shop where closingdate is null";
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
				String wkopeninghours = rs.getString(4);
				String wkshopphotoname = rs.getString(5);
				
				// File
				if (wkshopphotoname.equals(null)) {
					System.out.println("wksopphotoname is null");
					
				}else {
					File file = new File("./" + wkshopphotoname);
					FileOutputStream output = new FileOutputStream(wkshopphotoname);
					InputStream input = rs.getBinaryStream(6);
					byte[] buffer = new byte[1024];
					while(input.read(buffer) > 0) {
						output.write(buffer);
					}
				}		
				ShopDto shopdto = new ShopDto(wkshopid, wkshopaddress, wkshopphone, wkshopphotoname,wkopeninghours);
				BeanList.add(shopdto);
			}
		
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		return BeanList;
	}
	
	public ArrayList<ShopDto> conditionList(){
		
		ArrayList<ShopDto> BeanList = new ArrayList<ShopDto>();
		
		String whereStatement = "select shopid, shopaddress, shopphone, openinghours, shopphotoname, shopphoto from shop ";
		String whereStatement2 = "where "+ conname + " like '%" + condata +"%' and closingdate is null";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			//ResultSet rs = stmt_mysql.executeQuery(whereStatement);
			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			while(rs.next()) {
				
				String wkshopid = rs.getString(1);
				String wkshopaddress = rs.getString(2);
				String wkshopphone = rs.getString(3);
				String wkopeninghours = rs.getString(4);
				String wkshopphotoname = rs.getString(5);
				
				// File
				File file = new File("./" + wkshopphotoname);
				FileOutputStream output = new FileOutputStream(wkshopphotoname);
				InputStream input = rs.getBinaryStream(6);
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}
								
				ShopDto shopdto = new ShopDto(wkshopid, wkshopaddress, wkshopphone, wkshopphotoname, wkopeninghours);
				BeanList.add(shopdto);
			}
		
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		return BeanList;
	}
/*
	public ShopDto tableClick() {
		
		ShopDto dto = null;
		
		String whereStatement = "select shopid, shopaddress, shopphone, openinghours, shopphotoname, shopphoto from shop ";
		String whereStatement2 = "where shopid = "+ shopid;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			while(rs.next()) {
				
				String wkshopid = rs.getString(1);
				String wkaddress = rs.getString(2);
				String wkphone = rs.getString(3);
				String wkopeninghours = rs.getString(4);				
				String wkphotoname = rs.getString(5);
				
				// File
				File file = new File("./" + wkphotoname);
				FileOutputStream output = new FileOutputStream(wkphotoname);
				InputStream input = rs.getBinaryStream(6);
				byte[] buffer = new byte[1024];
				while(input.read(buffer) > 0) {
					output.write(buffer);
				}				
				
				dto = new ShopDto(wkshopid, wkaddress, wkphone, wkphotoname, wkopeninghours);
				
			}
				
			conn_mysql.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	*/	
}

