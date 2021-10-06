package com.example.creationaldesignpatterns.builder.runner;

import com.example.creationaldesignpatterns.builder.entity.User;

public class Runner {
	public static void main(String[] args) {
		
		User user = new User.UserBuilder().tckn(123).lastName("bekir").surName("zeyveli").build();
		System.out.println(user);
	}
}
