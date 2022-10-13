package com.coffeex.kioskdao;

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
import com.coffeex.dto.ViewCartDto;
import com.coffeex.kiosk.KioskOrder;
import com.coffeex.util.CustomerInfo;
import com.coffeex.util.DBConnect;

public class KioskOrderDao {

	public KioskOrderDao() {

	}

	public ArrayList<ViewCartDto> ShowCart(String custid) {

		ArrayList<ViewCartDto> dtoList = new ArrayList<ViewCartDto>();
		String whereStatement = "select menu, price, quantity, addoption from viewcart ";
		String whereStatement2 = "where custid='" + custid + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			while (rs.next()) {
				String wkName = rs.getString(1);
				int wkPrice = rs.getInt(2);
				int wkQuantity = rs.getInt(3);
				String wkOption = rs.getString(4);
				ViewCartDto dto = new ViewCartDto(wkName, wkPrice, wkQuantity, wkOption);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (

		Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}

	public void emptyCart(String custid) {

		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "delete from addcart where ";
			String whereStatement1 = "custid='" + custid + "'";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);
			ps.executeUpdate();

			// 데이터베이스 연결종료
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean checkCart(String custid, String menuname, String option) {
		PreparedStatement ps = null;
		int wkCount = 1;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "select count(*) from viewcart where ";
			String whereStatement2 = "custid='" + custid + "' and menu='" + menuname + "' and addoption='" + option
					+ "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement2);

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {
				wkCount = rs.getInt(1);
			}

			conn_mysql.close();

			if (wkCount >= 1) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void AddCart(int mmanageid, String custid, int addcartquantity, String addcartoption) {

		PreparedStatement ps = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "insert into addcart (mmanegeid, custid, addcartdate, addcartquantity, addcartoption) ";
			String whereStatement1 = "values (?,?,curdate(),?,?); ";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);
			ps.setInt(1, mmanageid);
			ps.setString(2, custid);
			ps.setInt(3, addcartquantity);
			ps.setString(4, addcartoption);
			// 실행
			ps.executeUpdate();

			// 데이터베이스 연결종료
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void AddQuantity(String mmanageid, String custid, String addcartoption, int quantity) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "update addcart set addcartquantity=addcartquantity+" + quantity;
			String whereStatement1 = " where mmanegeid='" + mmanageid + "' and custid='" + custid
					+ "' and addcartoption='" + addcartoption + "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);
			ps.executeUpdate();
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int checkCustomerByPhone(String phone) {
		PreparedStatement ps = null;
		int wkCount = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "select count(*) from customer ";
			String whereStatement1 = " where custphone='" + phone + "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);

			if (rs.next()) {
				wkCount = rs.getInt(1);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wkCount;
	}

	public int checkPoint(String phone) {
		PreparedStatement ps = null;
		int wkPoint = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "select custpoint from customer ";
			String whereStatement1 = " where custphone='" + phone + "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);

			if (rs.next()) {
				wkPoint = rs.getInt(1);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wkPoint;
	}

	public void usePoint(String phone, int cost) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "update customer set custpoint=custpoint-" + cost;
			String whereStatement1 = " where custphone='" + phone + "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);
			ps.executeUpdate();
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addPoint(String phone, int cost) {
		PreparedStatement ps = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "update customer set custpoint=custpoint+" + cost;
			String whereStatement1 = " where custphone='" + phone + "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);
			ps.executeUpdate();
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Order(int staffid, String menuid, String option, int quantity, String custid, int price, String place) {
		PreparedStatement ps = null;
		KioskSetOptionDao dao = new KioskSetOptionDao();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "insert into orders (ordersstaffid, ordersshopid, orderscustomerid, ordersmmanageid, ordersstatus, ordersquantity, ordersoption, orderssaleprice, ordersplaceselect, ordersdate) ";
			String whereStatement1 = "values(?,?,?,?,'주문접수',?,?,?,?,curdate()); ";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);
			ps.setInt(1, staffid);
			ps.setString(2, CustomerInfo.shopname);
			ps.setString(3, custid);
			ps.setInt(4, dao.getMenuId(menuid));
			ps.setInt(5, quantity);
			ps.setString(6, option);
			ps.setInt(7, price);
			ps.setString(8, place);
			// 실행
			ps.executeUpdate();

			// 데이터베이스 연결종료
			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String searchCustomerByPhone(String phone) {
		PreparedStatement ps = null;
		String wkCustid = "";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			String whereStatement = "select custid from customer";
			String whereStatement1 = " where custphone='" + phone + "';";

			ps = conn_mysql.prepareStatement(whereStatement + whereStatement1);

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement1);

			if (rs.next()) {
				wkCustid = rs.getString(1);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return wkCustid;
	}

	public ArrayList<Integer> searchStaff() {
		PreparedStatement ps = null;
		int wkStaffid = 0;
		ArrayList<Integer> staffid = new ArrayList<Integer>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
//			String whereStatement = "select punchstaffid from punchinout ";
//			String whereStatement1 = "where now()> (select punchintime from punchinout where date(punchintime)=curdate()) ";
//			String whereStatement2 = "and (now()<(select punchouttime from punchinout where date(punchouttime)=curdate()) ";
//			String whereStatement3 = "or (select punchouttime from punchinout where date(punchouttime)=curdate()) is null) ";
//			String whereStatement4 = "and punchshopid='" + DBConnect.shopname;
			String whereStatement="Select staffid from staff, belong where staffid=belongstaffid and belongshopid='" + CustomerInfo.shopname + "';";

			ps = conn_mysql.prepareStatement(whereStatement);

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				wkStaffid = rs.getInt(1);
				staffid.add(wkStaffid);
			}

			conn_mysql.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return staffid;
	}
	
	
}
