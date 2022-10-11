package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.NoticeDto;
import com.coffeex.util.DBConnect;
import com.mysql.cj.protocol.x.Notice;

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
		String whereStatement = "select noticeid,noticetitle,noticetext,noticeinsertdate, noticeupdatedate from notice ";
		String whereStatement2 = "where noticeid='" + noticeid + "'";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement + whereStatement2);

			if (rs.next()) {
				int wkNoticeid = rs.getInt(1);
				String wkNoticeTitle = rs.getString(2);
				String wkNoticetext = rs.getString(3);
				String wkinsertdate = rs.getString(4);
				String wkinupdatedate = rs.getString(5);

				dto = new NoticeDto(wkNoticeid, wkNoticeTitle, wkNoticetext, wkinsertdate, wkinupdatedate);
				
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public ArrayList<NoticeDto> NoticeselectList() {

		ArrayList<NoticeDto> dtoList = new ArrayList<NoticeDto>();
		String whereStatement = "select noticeid,noticetitle, noticeinsertdate, noticeupdatedate from notice;";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql, DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {
				int wkNoticeid = rs.getInt(1);
				String wkNoticeTitle = rs.getString(2);
				String wkinsertdate = rs.getString(3);
				String wkinupdatedate = rs.getString(4);

				NoticeDto dto = new NoticeDto(wkNoticeid, wkNoticeTitle, wkinsertdate, wkinupdatedate);
				dtoList.add(dto);
			}

			conn_mysql.close(); // Close DB connection for others to connect
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dtoList;
	}
	
}
