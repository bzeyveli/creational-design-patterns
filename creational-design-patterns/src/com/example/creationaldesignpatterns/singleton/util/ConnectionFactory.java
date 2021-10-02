package com.example.creationaldesignpatterns.singleton.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.creationaldesignpatterns.singleton.constants.ConnectionConstants;

public final class ConnectionFactory {

	private static Connection connection = null;

	private ConnectionFactory() {

	}

	public static Connection getInstance() {
		if (connection == null) {
			synchronized (Connection.class) {
				if (connection == null) {
					try {
						LogUtil.info("Ba�lant� kuruluyor...");
						connection = DriverManager.getConnection(ConnectionConstants.DB_URL, ConnectionConstants.USER,
								ConnectionConstants.PASSWORD);
						LogUtil.info("Ba�lant� ba�ar�l� bir �ekilde kuruldu.");
					} catch (SQLException e) {
						LogUtil.error("Ba�lant� kurulamad�.");
						e.printStackTrace();
					}
				}
			}
		}

		return connection;
	}

	public static void close() {
		if (connection != null) {
			try {
				LogUtil.error("Ba�lant� kapat�l�yor...");
				connection.close();
				LogUtil.error("Ba�lant� kapat�ld�.");
			} catch (SQLException e) {
				LogUtil.error("Ba�lant� kapat�l�rken hata ile kar��la�t�.");
				e.printStackTrace();
			}
		}
	}

}
