package com.coffeex.staffdao;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.coffeex.dto.MenuViewDto;
import com.coffeex.util.DBConnect;

public class ManagerChangeMenuDao {
	
	public ArrayList<MenuViewDto> ShowManagerMenu() {
		ArrayList<MenuViewDto> dtoList = new ArrayList<MenuViewDto>();
		String whereStatement = "select photo, menuname, price from mmanage ";
		String WhereStatement2 = "where date(updatedate)=curdate() or date(createdate)=curdate();";
		DBConnect.filename=0;
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
}
