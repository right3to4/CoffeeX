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
import com.coffeex.kioskdao.KioskSetOptionDao;
import com.coffeex.util.CustomerInfo;
import com.coffeex.util.DBConnect;

public class ManagerChangeMenuDao {

	public ArrayList<MenuViewDto> ShowAllMenu() {
		ArrayList<MenuViewDto> dtoList = new ArrayList<MenuViewDto>();
		String whereStatement = "select menuid, mcategory, menuname, mprice, date(mcreatedate), date(mupdatedate) from menu ";
		String whereStatement2 = "where mdeletedate is null and menu.menuid not in (select managermenumanage.menuid from managermenumanage where shopname='" + DBConnect.shopname + "');";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement+whereStatement2);

			while (rs.next()) {
				int Menuid = rs.getInt(1);
				String category = rs.getString(2);
				String Menuname = rs.getString(3);
				int price = rs.getInt(4);
				String createdate = rs.getString(5);
				String updatedate = rs.getString(6);
				MenuViewDto dto = new MenuViewDto(Menuid, category, Menuname, price, createdate, updatedate);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	public ArrayList<MenuViewDto> ShowShopMenu() {
		ArrayList<MenuViewDto> dtoList = new ArrayList<MenuViewDto>();
		String whereStatement = "select menuid, category, menuname, price, date(createdate), date(updatedate) from managermenumanage ";
		String whereStatement2 = "where shopname='" + DBConnect.shopname + "';";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {
				int Menuid = rs.getInt(1);
				String category = rs.getString(2);
				String Menuname = rs.getString(3);
				int price = rs.getInt(4);
				String createdate = rs.getString(5);
				String updatedate = rs.getString(6);
				MenuViewDto dto = new MenuViewDto(Menuid, category, Menuname, price, createdate, updatedate);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
	
	public String getInfo(String menuid) {
		String whereStatement = "select menuinfo from menu ";
		String whereStatement2 = "where menuid='" + menuid + "';";
		String menuInfo=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {
				menuInfo=rs.getString(1);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}
		return menuInfo;
	}
	
	public void addMenu(String menuid) {
		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "insert into menumanage (mmanageid, mmanagestaffid, mmanageshopid, mmanagemenuid, mmanagecreatedate) ";
			String whereStatement1 = "values(1,?,?,?,curdate()); ";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);
			ps.setInt(1, 351315);
			ps.setString(2, DBConnect.shopname);
			ps.setString(3, menuid);
			
			// 실행
			ps.executeUpdate();

			// 데이터베이스 연결종료
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
