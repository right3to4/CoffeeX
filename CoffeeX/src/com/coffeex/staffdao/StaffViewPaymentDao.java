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

		String whereStatement = "select payamount, payincentive, substring(paydate, 1, 10) from pay";
		String whereStatement2=" where paystaffid = " + CustomerInfo.staffid + " order by paydate;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

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

	public ArrayList<PayDto> selectPayYM() {
		ArrayList<PayDto> paydto = new ArrayList<PayDto>();

		String whereStatement1 = "select payamount, payincentive, substring(paydate, 1, 10) ";
		String whereStatement2 = "from pay where paydate like '" + cbDate + "%' and paystaffid='" + CustomerInfo.staffid + "' order by paydate";
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
		ArrayList<String> cbPayDate = new ArrayList<>();
		String sql = "select substring(paydate, 1, 7) from pay group by substring(paydate, 1, 7) order by substring(paydate, 1, 7)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(sql);
			while (rs.next()) {

				cbPayDate.add(rs.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cbPayDate;
	}

}
