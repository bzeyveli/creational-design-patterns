package com.example.creationaldesignpatterns.singleton.runner;

import java.sql.Connection;

import com.example.creationaldesignpatterns.singleton.util.JdbcUtil;

public class Runner {

	public static void main(String[] args) {
		Connection connection1 = JdbcUtil.getConnection();
		Connection connection2 = JdbcUtil.getConnection();
		boolean isSame = (connection1 == connection2);
		boolean isNotSame = (connection1 != connection2);
<<<<<<< HEAD
		boolean result = (connection1 != connection2);
=======
		boolean isNotSame2 = (connection1 != connection2);
>>>>>>> branch 'master' of https://github.com/bzeyveli/creational-design-patterns.git
		System.out.println("isSame : " + isSame);
	}

}
