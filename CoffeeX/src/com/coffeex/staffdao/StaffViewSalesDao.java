package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.OrdersDto;
import com.coffeex.dto.PayDto;
import com.coffeex.staff.StaffViewPayment;
import com.coffeex.util.CustomerInfo;
import com.coffeex.util.DBConnect;

public class StaffViewSalesDao {

	// Fields

	int orderstaffid;
	String ordersmmanageid;
	int ordersquantity;
	int orderssaleprice;
	String ordersdate;

	public static String cbDate;

	// Constructor
	public StaffViewSalesDao() {
		// TODO Auto-generated constructor stub
	}

	public StaffViewSalesDao(int orderstaffid, String ordersmmanageid, int ordersquantity, int orderssaleprice,
			String ordersdate) {
		super();
		this.orderstaffid = orderstaffid;
		this.ordersmmanageid = ordersmmanageid;
		this.ordersquantity = ordersquantity;
		this.orderssaleprice = orderssaleprice;
		this.ordersdate = ordersdate;
	}

	// Method

	public ArrayList<OrdersDto> selectStaffSales() {

		ArrayList<OrdersDto> ordersdto = new ArrayList<OrdersDto>();

		String whereStatement1 = "select m.menuname, o.ordersquantity, o.orderssaleprice, substring(o.ordersdate, 1, 10) ";
		String whereStatement2 = "from orders o, menu m where m.menuid = o.ordersmmanageid";
		String whereStatement3 = " and ordersstaffid='" + CustomerInfo.staffid + "' order by ordersdate";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement1 + whereStatement2 + whereStatement3);

			while (rs.next()) {
				int wkordersstaffid = CustomerInfo.staffid;
				String wkordersmmanageid = rs.getString(1);
				int wkordersquantity = rs.getInt(2);
				int wkorderssaleprice = rs.getInt(3);
				String wkordersdate = rs.getString(4);

				OrdersDto dto = new OrdersDto(wkordersstaffid, wkordersmmanageid, wkordersquantity, wkorderssaleprice,
						wkordersdate);
				ordersdto.add(dto);
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordersdto;
	}

	public ArrayList<OrdersDto> selectSalesYM() {
		ArrayList<OrdersDto> ordersdto = new ArrayList<OrdersDto>();

		String whereStatement1 = "select m.menuname, o.ordersquantity, o.orderssaleprice, substring(o.ordersdate, 1, 10) ";
		String whereStatement2 = "from orders o, menu m where m.menuid = o.ordersmmanageid and ordersdate like '" + cbDate + "%'";
		String whereStatement3 = " and ordersstaffid=' " + CustomerInfo.staffid + "' order by ordersdate";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement1 + whereStatement2 + whereStatement3);

			while (rs.next()) {

				int wkordersstaffid = CustomerInfo.staffid;
				String wkordersmmanageid = rs.getString(1);
				int wkordersquantity = rs.getInt(2);
				int wkorderssaleprice = rs.getInt(3);
				String wkordersdate = rs.getString(4);

				OrdersDto dto = new OrdersDto(wkordersstaffid, wkordersmmanageid, wkordersquantity, wkorderssaleprice,
						wkordersdate);
				ordersdto.add(dto);
			}
			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ordersdto;
	}

	public ArrayList<String> loadSalesYM() {
		ArrayList<String> cbSalesDate = new ArrayList<>();
		String sql1 = "select substring(ordersdate, 1, 7) from orders group by substring(ordersdate, 1, 7) order by substring(ordersdate, 1, 7)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			ResultSet rs = stmt_mysql.executeQuery(sql1);
			while (rs.next()) {

				cbSalesDate.add(rs.getString(1));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cbSalesDate;
	}

}
