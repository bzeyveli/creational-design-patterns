package com.example.creationaldesignpatterns.singleton.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class LogUtil {

	private static final Logger LOGGER = Logger.getLogger(LogUtil.class.getName());

	static {

		LOGGER.setLevel(Level.INFO);
	}

	private LogUtil() {

	}

	public static void info(String msg) {
		LOGGER.info(msg);
	}

	public static void warning(String msg) {
		LOGGER.warning(msg);
	}

	public static void error(String msg) {
		LOGGER.severe(msg);
	}

}
