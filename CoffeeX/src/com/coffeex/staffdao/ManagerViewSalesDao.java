package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.OrdersViewDto;
import com.coffeex.util.CustomerInfo;
import com.coffeex.util.DBConnect;

public class ManagerViewSalesDao {

	public ManagerViewSalesDao() {

	}

	public ArrayList<OrdersViewDto> searchSalesByMonth() {
		ArrayList<OrdersViewDto> dtoList = new ArrayList<OrdersViewDto>();
		String whereStatement = "select substring(dates, 1, 7), sum(quantity), sum(price) from orderview";
		String whereStatement2=	"where staff='" + CustomerInfo.staffname + "' group by substring(dates, 1, 7)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkYear = rs.getString(1);
				int wkQuantity = rs.getInt(2);
				int wkSum = rs.getInt(3);

				OrdersViewDto dto = new OrdersViewDto(wkYear, wkQuantity, wkSum);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public ArrayList<OrdersViewDto> searchSalesByMenu() {
		ArrayList<OrdersViewDto> dtoList = new ArrayList<OrdersViewDto>();
		String whereStatement = "select menu, sum(quantity), sum(price) from orderview group by menu";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkMenu = rs.getString(1);
				int wkQuantity = rs.getInt(2);
				int wkSum = rs.getInt(3);

				OrdersViewDto dto = new OrdersViewDto(wkMenu, wkQuantity, wkSum);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public ArrayList<OrdersViewDto> searchSalesByStaff() {
		ArrayList<OrdersViewDto> dtoList = new ArrayList<OrdersViewDto>();
		String whereStatement = "select staff, sum(quantity), sum(price) from orderview group by staff";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkStaff = rs.getString(1);
				int wkQuantity = rs.getInt(2);
				int wkSum = rs.getInt(3);

				OrdersViewDto dto = new OrdersViewDto(wkStaff, wkQuantity, wkSum);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}

	public ArrayList<OrdersViewDto> searchSalesByShop() {
		ArrayList<OrdersViewDto> dtoList = new ArrayList<OrdersViewDto>();
		String whereStatement = "select shop, quantity, sum(price) from orderview group by staff";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkStaff = rs.getString(1);
				int wkQuantity = rs.getInt(2);
				int wkSum = rs.getInt(3);

				OrdersViewDto dto = new OrdersViewDto(wkStaff, wkQuantity, wkSum);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
}
