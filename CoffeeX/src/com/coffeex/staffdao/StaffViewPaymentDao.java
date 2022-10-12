package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.PayDto;
import com.coffeex.staff.StaffViewPayment;
import com.coffeex.util.CustomerInfo;
import com.coffeex.util.DBConnect;

public class StaffViewPaymentDao {

	// Fields
	int paystaffid;
	String paydate;
	int payamount;
	int payincentive;

	public static String cbDate;

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

	// Method

	public ArrayList<PayDto> selectStaffPay() {

		ArrayList<PayDto> paydto = new ArrayList<PayDto>();

		String whereStatement = "select paystaffid, payamount, payincentive, substring(paydate, 1, 10) from pay order by paydate";
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

	public ArrayList<PayDto> selectPayYM() {
		ArrayList<PayDto> paydto = new ArrayList<PayDto>();

		String whereStatement1 = "select payamount, payincentive, substring(paydate, 1, 10) ";
		String whereStatement2 = "from pay where paydate like '" + cbDate + "%' order by paydate";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement1 + whereStatement2);

			while (rs.next()) {

				int wkpaystaffid = CustomerInfo.staffid;
				int wkpayamount = rs.getInt(1);
				int wkpayincentive = rs.getInt(2);
				String wkpaydate = rs.getString(3);

				PayDto dto = new PayDto(wkpaystaffid, wkpayamount, wkpayincentive, wkpaydate);
				paydto.add(dto);
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return paydto;
	}

	public ArrayList<String> loadPayYM() {
		ArrayList<String> cbDate = new ArrayList<>();
		String sql = "select concat(year(paydate), '-', month(paydate)) ym from pay group by ym";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(sql);
			while (rs.next()) {

				cbDate.add(rs.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cbDate;
	}

//	public PayDto selectSum() {
//		PayDto dto = null;
//		String sql = "select concat(year(paydate), '-', month(paydate)) ym, sum(payamount), sum(payincentive) from pay group by ym";
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
//			Statement stmt_mysql = conn_mysql.createStatement();
//			ResultSet rs = stmt_mysql.executeQuery(sql);
//			while (rs.next()) {
//				String wkpaydate = rs.getString(1);
//				int wkpayamount = rs.getInt(2);
//				int wkincentive = rs.getInt(3);
//
//				dto = new PayDto(wkpayamount, wkincentive, wkpaydate);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dto;
//	}

}
