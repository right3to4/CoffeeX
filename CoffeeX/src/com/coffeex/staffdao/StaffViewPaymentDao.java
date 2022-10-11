package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.PayDto;
import com.coffeex.util.DBConnect;

public class StaffViewPaymentDao {

	// Fields
	int paystaffid;
	String paydate;
	int payamount;
	int payincentive;

	// Constructor
	public StaffViewPaymentDao() {
		// TODO Auto-generated constructor stub
	}

	public StaffViewPaymentDao(int paystaffid, String paydate, int payamount, int payincentive) {
		super();
		this.paystaffid = paystaffid;
		this.paydate = paydate;
		this.payamount = payamount;
		this.payincentive = payincentive;
	}

	public StaffViewPaymentDao(String paydate) {
		super();
		this.paydate = paydate;
	}

	// Method

	public ArrayList<PayDto> selectStaffPay() {

		ArrayList<PayDto> paydto = new ArrayList<PayDto>();

		String whereStatement = "select paystaffid, payamount, payincentive, paydate from pay";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {

				int wkpaystaffid = rs.getInt(1);
				int wkpayamount = rs.getInt(2);
				int wkpayincentive = rs.getInt(3);
				String wkpaydate = rs.getString(4);

				PayDto dto = new PayDto(wkpaystaffid, wkpayamount, wkpayincentive, wkpaydate);
				paydto.add(dto);
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return paydto;
	}
	
	public String [] selectPayDate1() {
		String sql = "select paydate from coffeex.pay";
		String [] paydateList = new String [3];
		int i=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(sql);
			while (rs.next()) {
				rs.getString(1);
				paydateList[i]=rs.getString(1);
				i++;
			}
			
		}catch (Exception e) {
		}return paydateList;
	}

//	public ArrayList<String> selectPayDate() {
//		String sql = "select paydate from coffeex.pay";
//		ArrayList<String> paydateList = new ArrayList<>();
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
//			Statement stmt_mysql = conn_mysql.createStatement();
//			ResultSet rs = stmt_mysql.executeQuery(sql);
//			while (rs.next()) {
//				rs.getString(1);
//				paydateList.add(rs.getString(1));
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return paydateList;
//	}

} ////////////////////////편집점 last


////////////////////////편집점
