package com.coffeex.staffdao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.MenuViewDto;
import com.coffeex.dto.NoticeDto;
import com.coffeex.dto.OrdersViewDto;
import com.coffeex.util.DBConnect;

public class ChiefSearchSalesDao {

	public ChiefSearchSalesDao() {

	}

	public ArrayList<OrdersViewDto> ShowSalesByShops(String group, String ad) {

		ArrayList<OrdersViewDto> dtoList = new ArrayList<OrdersViewDto>();
		String whereStatement = "select shop, sum(quantity), sum(price) from orderview group by shop order by " + group + " " + ad;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkShop = rs.getString(1);
				int wkSum = rs.getInt(2);
				int wkPrice = rs.getInt(3);

				OrdersViewDto dto = new OrdersViewDto(wkShop, wkSum, wkPrice);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
	
	public ArrayList<OrdersViewDto> ShowSalesByMenu(String group, String ad) {

		ArrayList<OrdersViewDto> dtoList = new ArrayList<OrdersViewDto>();
		String whereStatement = "select menu, sum(quantity), sum(price) from orderview group by menu order by " + group + " " + ad;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkMenu = rs.getString(1);
				int wkSum = rs.getInt(2);
				int wkPrice = rs.getInt(3);

				OrdersViewDto dto = new OrdersViewDto(wkMenu, wkSum, wkPrice);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
	
	public ArrayList<OrdersViewDto> ShowSalesByStaff(String group, String ad) {

		ArrayList<OrdersViewDto> dtoList = new ArrayList<OrdersViewDto>();
		String whereStatement = "select staff, sum(quantity), sum(price) from orderview group by staff order by " + group + " " + ad;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				String wkStaff = rs.getString(1);
				int wkSum = rs.getInt(2);
				int wkPrice = rs.getInt(3);

				OrdersViewDto dto = new OrdersViewDto(wkStaff, wkSum, wkPrice);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	public void AlterStatus(int orderid, String status) {
		String whereStatement = "update orders set ordersstatus='" + status + "'";
		String whereStatement2 = "where orderid=" + orderid + "";
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			ps = conn_mysql.prepareStatement(whereStatement + whereStatement2);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public ArrayList<OrdersViewDto> ShowChiefList(String status) {

		ArrayList<OrdersViewDto> dtoList = new ArrayList<OrdersViewDto>();
		String whereStatement = "select orderid, menu, quantity, ordersoption, place from orderview ";
		String whereStatement2 = "where ordersstatus='" + status + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {
				int wkOrderid = rs.getInt(1);
				String wkMenu = rs.getString(2);
				int wkQuantity = rs.getInt(3);
				String wkOption = rs.getString(4);
				String wkPlace = rs.getString(5);

				OrdersViewDto dto = new OrdersViewDto(wkOrderid, wkMenu, wkQuantity, wkOption, wkPlace);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
	
	
}
