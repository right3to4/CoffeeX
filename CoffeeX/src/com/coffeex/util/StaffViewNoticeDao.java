package com.coffeex.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.coffeex.dto.NoticeDto;
import com.javalec.dto.DtoProduct;
import com.javalec.util.DBConnect;

public class StaffViewNoticeDao {

	int noticeid;
	int noticestaffid;
	String noticetitle;
	String noticetext;
	String noticeinsertdate;
	String noticeupdatedate;
	String noticedeletedate;
	
	public StaffViewNoticeDao() {
		// TODO Auto-generated constructor stub
	}

	public StaffViewNoticeDao(int noticeid) {
		super();
		this.noticeid = noticeid;
	}
	
	public NoticeDto tableClick() {
		NoticeDto dto = null;
		String whereStatement = "select noticeid,noticetitle,noticetext,noticeinsertdate from notice";
		String whereStatement2 = "where noticeid='" + noticeid + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {
				String wkProductid = rs.getString(1);
				String wkName = rs.getString(2);
				int wkPrice = rs.getInt(3);

				dto = new DtoProduct(wkProductid, wkName, wkPrice);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}
