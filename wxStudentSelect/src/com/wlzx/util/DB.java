package com.wlzx.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DB {

	public ResultSet executeQuery(String sql) throws Exception {
		ResultSet rs = null;
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			throw e;
		}
		return rs;
	}
	public void executeUpdate(String sql) throws Exception {
		Connection conn = null;
		Statement stmt = null;
		try {
			conn = ConnectionFactory.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("执行sql语句出错"+e.getMessage());
		} finally{
			DbClose.close(stmt, conn);
		}
	}
}
