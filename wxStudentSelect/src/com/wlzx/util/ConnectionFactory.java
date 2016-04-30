package com.wlzx.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 获取数据库连接
 * @author 赵世朋
 *
 */
public class ConnectionFactory {
	private static String DRIVER = "";
	private static String URL = "";
	private static String USERNAME = "";
	private static String PASSWORD = "";

	public ConnectionFactory() {
		// TODO Auto-generated constructor stub
	}

	static {
		getPeopertiesInfo();
	}
	/**
	 * 该方法用来获得属性文件中的driver，url，username，password
	 */
	private static void getPeopertiesInfo() {
		Properties prop = new Properties();
		InputStream inputStream = Thread.currentThread()
				.getContextClassLoader().getResourceAsStream("jdbc.properties");
		try {
			//获取相应的键值对
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		//根据相应的键获取对应的值
		DRIVER = prop.getProperty("driver");
		URL = prop.getProperty("url");
		USERNAME = prop.getProperty("username");
		PASSWORD = prop.getProperty("password");

	}
	/**
	 * 该方法用来加载驱动，并获取数据库的连接对象
	 * @return 数据库连接对象conn
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			//加载驱动
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			//获取数据库连接对象
			conn = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
}
