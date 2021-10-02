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
						LogUtil.info("Baðlantý kuruluyor...");
						connection = DriverManager.getConnection(ConnectionConstants.DB_URL, ConnectionConstants.USER,
								ConnectionConstants.PASSWORD);
						LogUtil.info("Baðlantý baþarýlý bir þekilde kuruldu.");
					} catch (SQLException e) {
						LogUtil.error("Baðlantý kurulamadý.");
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
				LogUtil.error("Baðlantý kapatýlýyor...");
				connection.close();
				LogUtil.error("Baðlantý kapatýldý.");
			} catch (SQLException e) {
				LogUtil.error("Baðlantý kapatýlýrken hata ile karþýlaþtý.");
				e.printStackTrace();
			}
		}
	}

}
