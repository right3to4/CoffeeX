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

	public ArrayList<String> selectPayDate() {
		ArrayList<String> dtoList = new ArrayList<>();
		String sql = "select concat(year(paydate), '-', month(paydate)) ym, sum(payamount), sum(payincentive) from pay group by ym";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(sql);
			while (rs.next()) {
				String wkpaydate = rs.getString(1);
				dtoList.add(rs.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

}
