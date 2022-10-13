package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.StaffDto;
import com.coffeex.util.CustomerInfo;
import com.coffeex.util.DBConnect;


public class ManagerAddStaffDao {
	
	int staffid;
	String staffname;
	String staffpw;
	String staffphone;
	int staffhourlywage;
	String staffinitdate;
	String staffdeletedate;
	
	
	String conname;
	String condata;
	
	public ManagerAddStaffDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ManagerAddStaffDao(String conname, String condata) {
		super();
		this.conname = conname;
		this.condata = condata;
	}


	public ManagerAddStaffDao(int staffid, String staffname, String staffpw, String staffphone, int staffhourlywage) {
		super();
		this.staffid = staffid;
		this.staffname = staffname;
		this.staffpw = staffpw;
		this.staffphone = staffphone;
		this.staffhourlywage = staffhourlywage;
	}


	public ManagerAddStaffDao(int staffid) {
		super();
		this.staffid = staffid;
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
			String query1 = "values (?,'알바',now());";
			//데이터입력
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setInt(1, staffid);

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

	public boolean deleteAction(int staffid) {
	PreparedStatement ps = null;
	try {
		//sql접속
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
		Statement stmt_mysql = conn_mysql.createStatement();
		//쿼리문작성
		String query = "update staff set staffdeletedate = now() where staffid = ? ";
		//데이터입력
		ps = conn_mysql.prepareStatement(query);
	
		ps.setInt(1, staffid);
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
	
	public ArrayList<StaffDto> conditionList(){
		
		ArrayList<StaffDto> dtoList = new ArrayList<StaffDto>();
		
		String whereStatement = "select staffid, staffname, staffphone, staffinitdate from staff,promote,belong ";
		String whereStatement2 = "where "+ conname + " like '%" + condata +"%' and staffdeletedate is null and promotestaffid = staffid and position = '직원' and '"+ CustomerInfo.shopname + "' = belongshopid and belongstaffid = staffid ";
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
				
				StaffDto dto = new StaffDto(wkstaffid, wkstaffname, wkstaffphone, wkstaffinitdate);
				dtoList.add(dto);
				
			}
		
			conn_mysql.close();
			
		}catch(Exception e) {
			e.printStackTrace();
			}
		return dtoList;
	}
	
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
	
	
}
