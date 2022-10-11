package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.ShopDto;
import com.coffeex.dto.StaffDto;
import com.coffeex.util.DBConnect;

public class ChefUpdateStaffDao {
	
	int staffid;
	String staffname;
	String staffpw;
	String staffphone;
	int staffhourlywage;
	String staffinitdate;
	String staffdeletedate;
	String shopid;

	String conname;
	String condata;
	
	String position;
	
	

	public ChefUpdateStaffDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ChefUpdateStaffDao(String conname, String condata) {
		super();
		this.conname = conname;
		this.condata = condata;
	}
	
	public ChefUpdateStaffDao(int staffid, String staffname, String staffpw, String staffphone, int staffhourlywage, String position) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffpw = staffpw;
		this.staffphone = staffphone;
		this.staffhourlywage = staffhourlywage;
		this.position=position;
	}
	

	public ChefUpdateStaffDao(int staffid, String staffname, String staffpw, String staffphone, int staffhourlywage,
			String shopid, String position) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffpw = staffpw;
		this.staffphone = staffphone;
		this.staffhourlywage = staffhourlywage;
		this.shopid = shopid;
		this.position = position;
	}

	public ArrayList<StaffDto> conditionList(){
		
		ArrayList<StaffDto> dtoList = new ArrayList<StaffDto>();
		
		String whereStatement = "select staffid, staffname, staffphone, staffinitdate, staffdeletedate, belongshopid, staffhourlywage from staff,promote,belong ";
		String whereStatement2 = "where "+ conname + " like '%" + condata +"%' and promotestaffid = staffid and belongstaffid = staffid";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);
			
			while(rs.next()) {
				
				int wkstaffid = rs.getInt(1);
				String wkstaffname = rs.getString(2);
				String wkstaffphone = rs.getString(3);
				String wkstaffinitdate = rs.getString(4);
				String wkstaffdeletedate = rs.getString(4);
				String wkbelong = rs.getString(5);
				int wkwage = rs.getInt(6);
				
				StaffDto dto = new StaffDto(wkstaffid, wkstaffname, wkstaffphone, wkwage, wkstaffinitdate, wkstaffdeletedate, wkbelong);
				dtoList.add(dto);
				
			}
		
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		return dtoList;
	}
	
public int insertArcion() {
		
		PreparedStatement ps = null;
		int check = 0;
		try {
			//sql접속
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			//쿼리문작성
			String query = "insert into staff (staffid, staffname, staffpw, staffphone, staffhourlywage, staffinitdate) ";
			String query1 = "values(?,?,?,?,?,now())";
			//데이터입력
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setInt(1, staffid);
			ps.setString(2, staffname);
			ps.setString(3, staffpw);
			ps.setString(4, staffphone);
			ps.setInt(5, staffhourlywage);
			//실행
			check = ps.executeUpdate();
			
			//데이터베이스 연결종료
			conn_mysql.close();
		}catch(Exception e) {
			e.printStackTrace();
			return check;
		}
		// 직급 추가
		try {
			//sql접속
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			//쿼리문작성
			String query = "insert into promote (promotestaffid, position, pdate) ";
			String query1 = "values (?, ? ,now());";
			//데이터입력
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setInt(1, staffid);
			ps.setString(2,position);

			//실행
			check = ps.executeUpdate();
			
			//데이터베이스 연결종료
			conn_mysql.close();
		}catch(Exception e) {
			e.printStackTrace();
			return check;
		}
		//지점 추가
		try {
			//sql접속
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			//쿼리문작성
			String query = "insert into belong (belongstaffid, belongshopid, belongdate) ";
			String query1 = "values (?, ? ,now());";
			//데이터입력
			ps = conn_mysql.prepareStatement(query +query1);
			ps.setInt(1, staffid);
			ps.setString(2,shopid);

			//실행
			check = ps.executeUpdate();
			
			//데이터베이스 연결종료
			conn_mysql.close();
		}catch(Exception e) {
			e.printStackTrace();
			return check;
		}
		return check;
	}
	public ArrayList<ShopDto> cbInsertShopid(){
	
	ArrayList<ShopDto> dtoList = new ArrayList<ShopDto>();
	
	String whereStatement = "select shopid from shop;";
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
		Statement stmt_mysql = conn_mysql.createStatement();

		ResultSet rs = stmt_mysql.executeQuery(whereStatement);
		
		while(rs.next()) {
			
			String wkshopid = rs.getString(1);
			
			
			ShopDto dto = new ShopDto(wkshopid);
			dtoList.add(dto);
		}
	
		conn_mysql.close();
		
	}catch(Exception e) {
		e.printStackTrace();
		}
	return dtoList;
	}

}
