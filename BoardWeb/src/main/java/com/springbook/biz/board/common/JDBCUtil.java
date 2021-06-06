package com.springbook.biz.board.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCUtil {

	/*
	 * public static Connection getConnection() { try {
	 * Class.forName("oracle.jdbc.driver.OracleDriver"); return
	 * DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr",
	 * "hr"); } catch (Exception e) { e.printStackTrace(); } return null; }
	 */

	/* mysql 설정 */ 
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/study?serverTimezone=Asia/Seoul", "study",
					"study");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// insert, update, delete문에서 사용
	public static void close(PreparedStatement stmt, Connection conn) {
		if (stmt != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
	}

	// select문에서 사용
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		if (rs != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}

		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}
	}
}
