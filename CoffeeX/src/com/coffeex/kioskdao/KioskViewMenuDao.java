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
import com.coffeex.util.DBConnect;

public class KioskViewMenuDao {

	int mmanageid;
	String photo;

	public KioskViewMenuDao() {

	}

	public ArrayList<MenuViewDto> ShowTodaysMenuList() {

		ArrayList<MenuViewDto> dtoList = new ArrayList<MenuViewDto>();
		String whereStatement = "select photo, menuname, price from mmanage ";
		String WhereStatement2 = "where date(updatedate)=curdate() or date(createdate)=curdate();";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + WhereStatement2);

			while (rs.next()) {
				String wkName = rs.getString(2);
				int wkPrice = rs.getInt(3);
				DBConnect.filename = DBConnect.filename + 1;
				File file = new File(Integer.toString(DBConnect.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(1);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);

				}
				MenuViewDto dto = new MenuViewDto(wkName, wkPrice, Integer.toString(DBConnect.filename));
				dtoList.add(dto);

			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	public ArrayList<MenuViewDto> ShowMenuListByCondition(String category) {

		ArrayList<MenuViewDto> dtoList = new ArrayList<MenuViewDto>();
		String whereStatement = "select photo, menuname, price from mmanage ";
		String whereStatement2 = "where category='" + category + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {
				String wkName = rs.getString(2);
				int wkPrice = rs.getInt(3);
				DBConnect.filename = DBConnect.filename + 1;
				File file = new File(Integer.toString(DBConnect.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(1);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}

				MenuViewDto dto = new MenuViewDto(wkName, wkPrice, Integer.toString(DBConnect.filename));
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	public int getMid(String menuname) {
		String whereStatement = "select menuid from menu ";
		String whereStatement2 = "where menuname='" + menuname + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {
				mmanageid = rs.getInt(1);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mmanageid;
	}

	public MenuViewDto searchDetail(String menuname) {
		MenuViewDto result = null;
		String wherestatement = "select menuname, photo, price from mmanage ";
		String wherestatement2 = "where menuname='" + menuname + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(wherestatement + wherestatement2);

			if (rs.next()) {
				String wkMenuname = rs.getString(1);
				int wkprice = rs.getInt(3);
				DBConnect.filename = DBConnect.filename + 1;
				File file = new File(Integer.toString(DBConnect.filename));
				FileOutputStream output = new FileOutputStream(file);
				InputStream input = rs.getBinaryStream(2);
				byte[] buffer = new byte[1024];
				while (input.read(buffer) > 0) {
					output.write(buffer);
				}
				result = new MenuViewDto(wkMenuname, wkprice);
				
	            conn_mysql.close();
			}
		} catch (Exception e) {

		}
		return result;
	}
}
