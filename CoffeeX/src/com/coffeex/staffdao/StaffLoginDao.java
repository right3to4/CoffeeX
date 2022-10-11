package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.util.CustomerInfo;
import com.coffeex.util.DBConnect;

public class StaffLoginDao {

	int staffid;
	String staffname;
	String staffpw;
	String staffphone;
	int staffhourlywage;
	String staffinitdate;
	String staffdeletedate;
	
	String position;
	
	public StaffLoginDao() {
		// TODO Auto-generated constructor stub
	}
	
	public StaffLoginDao(int staffid, String staffpw) {
		super();
		this.staffid = staffid;
		this.staffpw = staffpw;
	}

	public boolean loginAction() {
		int check =0;
		try{
			String whereStatement = "select count(staffid),staffname from staff ";
			String whereStatement2 = "where staffid = '" + staffid + "' and staffpw = '" + staffpw + "'"; 
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
		Statement stmt_mysql = conn_mysql.createStatement();

		ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

		while(rs.next()) {
			check = rs.getInt(1);
			CustomerInfo.staffname = rs.getString(2);
		}
		conn_mysql.close();
		
		} catch(Exception e) {
			e.printStackTrace(); // 개발자 에러 확인을 위해서.
		}
		if (check==1) {
			return true;
			
		}else {
			return false;
		}
			
	}
	
	public void positionAction() {
		try{
			String whereStatement = "select position from promote where promotestaffid = '"+ staffid+"'";
			
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
		Statement stmt_mysql = conn_mysql.createStatement();

		ResultSet rs = stmt_mysql.executeQuery(whereStatement);
		
		while(rs.next())
		{
			String wkposition = rs.getString(1);
			CustomerInfo.position =wkposition;
		}
		
		
		
		conn_mysql.close();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
