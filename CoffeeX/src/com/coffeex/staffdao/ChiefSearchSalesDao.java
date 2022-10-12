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

	public ArrayList<OrdersViewDto> ShowOrdersListByStatus(String status) {

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
}
