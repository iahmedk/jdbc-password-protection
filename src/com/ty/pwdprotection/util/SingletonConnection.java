package com.ty.pwdprotection.util;

import java.sql.*;
import static com.ty.pwdprotection.util.ApplicationConstants.*;

public class SingletonConnection {

	private static Connection con;

	private SingletonConnection() {
		// to prevent Connection obj creation from outside
	}

	static {

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {

		return con;
	}
}
