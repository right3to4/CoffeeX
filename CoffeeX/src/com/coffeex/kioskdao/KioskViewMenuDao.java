package com.coffeex.kioskdao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.MenuViewDto;
import com.coffeex.util.CustomerInfo;
import com.coffeex.util.DBConnect;

public class KioskViewMenuDao {

	int mmanageid;
	String photo;

	public KioskViewMenuDao() {

	}

	public ArrayList<MenuViewDto> ShowTodaysMenuList() {

		ArrayList<MenuViewDto> dtoList = new ArrayList<MenuViewDto>();
		String whereStatement = "select menuname, price from mmanage ";
		String WhereStatement2 = "where date(updatedate)=curdate() or date(createdate)=curdate() ";
		String whereStatement3 = "and shopname='" + "신림점" + "';";
//		String whereStatement3 = "and shopname='" + DBConnect.shopname + "';";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + WhereStatement2 + whereStatement3);

			while (rs.next()) {
				String wkName = rs.getString(1);
				int wkPrice = rs.getInt(2);
				MenuViewDto dto = new MenuViewDto(wkName, wkPrice, null);
				dtoList.add(dto);
//				DBConnect.filename = DBConnect.filename + 1;
//				File file = new File(Integer.toString(DBConnect.filename));
//				FileOutputStream output = new FileOutputStream(file);
//				InputStream input = rs.getBinaryStream(1);
//				byte[] buffer = new byte[1024];
//				while (input.read(buffer) > 0) {
//					output.write(buffer);
//				}

			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	public ArrayList<MenuViewDto> ShowMenuListByCondition(String category) {

		ArrayList<MenuViewDto> dtoList = new ArrayList<MenuViewDto>();
		String whereStatement = "select menuname, price from mmanage ";
		String whereStatement2 = "where category='" + category + "'";
		String whereStatement3 = " and shopname='" + CustomerInfo.shopname + "';";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2 + whereStatement3);

			while (rs.next()) {
				String wkName = rs.getString(1);
				int wkPrice = rs.getInt(2);
				MenuViewDto dto = new MenuViewDto(wkName, wkPrice, null);
				dtoList.add(dto);
//				DBConnect.filename = DBConnect.filename + 1;
//				File file = new File(Integer.toString(DBConnect.filename));
//				FileOutputStream output = new FileOutputStream(file);
//				InputStream input = rs.getBinaryStream(1);
//				byte[] buffer = new byte[1024];
//				while (input.read(buffer) > 0) {
//					output.write(buffer);
//				}

			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
}
