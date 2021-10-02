package com.example.creationaldesignpatterns.singleton.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public final class JdbcUtil {

	private static Connection connection = null;
	private static Statement statement = null;

	private JdbcUtil() {

	}

	public static Connection getConnection() {
		connection = ConnectionFactory.getInstance();
		return connection;
	}

	public static void closeConnection() {
		ConnectionFactory.close();
	}

	public static Statement getStatement() {
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return statement;
	}

	public static void closeStatement() {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
