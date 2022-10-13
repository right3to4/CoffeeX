package com.coffeex.staffdao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.coffeex.util.DBConnect;

public class ChefCreateNoticeDao {
	int noticeid;
	int noticestaffid;
	String noticetitle;
	String noticetext;
	String noticeinsertdate;
	String noticeupdatedate;
	String noticedeletedate;
	
	public ChefCreateNoticeDao() {
		// TODO Auto-generated constructor stub
	}
	
	public ChefCreateNoticeDao(int noticestaffid, String noticetitle, String noticetext) {
		super();
		this.noticestaffid = noticestaffid;
		this.noticetitle = noticetitle;
		this.noticetext = noticetext;
	}

	public int insertArcion() {
		
		PreparedStatement ps = null;
		int check = 0;
		try {
			//sql접속
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn_mysql = DriverManager.getConnection(DBConnect.url_mysql,DBConnect.id_mysql,DBConnect.pw);
			Statement stmt_mysql = conn_mysql.createStatement();
			//쿼리문작성
			String query = "insert into notice ( noticestaffid, noticetitle, noticetext, noticeinsertdate) ";
			String query1 = "values(?,?,?,now())";
			//데이터입력
			ps = conn_mysql.prepareStatement(query + query1);
			ps.setInt(1, noticestaffid);
			ps.setString(2, noticetitle);
			ps.setString(3, noticetext);
			ps.setString(4, noticeinsertdate);
			//실행
			check = ps.executeUpdate();
			
			//데이터베이스 연결종료
			conn_mysql.close();
		}catch(Exception e) {
			e.printStackTrace();
			return check;
		}
		return check;
	}
	
}
