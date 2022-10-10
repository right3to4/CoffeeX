package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.NoticeDto;
import com.coffeex.util.DBConnect;


public class ManagerViewOrdersDao {
	
	int noticeid;
	int noticestaffid;
	String noticetitle;
	String noticetext;
	String noticeinsertdate;
	String noticeupdatedate;
	String noticedeletedate;
	
	public ManagerViewOrdersDao() {
		// TODO Auto-generated constructor stub
	}

	public ManagerViewOrdersDao(int noticeid, String noticetitle, String noticeinsertdate, String noticeupdatedate) {
		super();
		this.noticeid = noticeid;
		this.noticetitle = noticetitle;
		this.noticeinsertdate = noticeinsertdate;
		this.noticeupdatedate = noticeupdatedate;
	}
	
	public ArrayList<NoticeDto> SelecNoticetList() {

		ArrayList<NoticeDto> dtoList = new ArrayList<NoticeDto>();

		String whereStatement = "select noticeid,noticetitle,noticeinsertdate,noticeupdatedate from notice";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql, DBConnect.id_mysql,
					DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();

			ResultSet rs = stmt_mysql.executeQuery(whereStatement);

			while (rs.next()) {

				int wknoticeid = rs.getInt(1);
				String wknoticetitle = rs.getString(2);
				String wknoticeinsertdate = rs.getString(3);
				String wknoticeupdatedate = rs.getString(4);
				

				NoticeDto dto = new NoticeDto(wknoticeid, wknoticetitle, wknoticeinsertdate, wknoticeupdatedate);
				dtoList.add(dto);

			}

			conn_mysql.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return dtoList;
	}
	
}
