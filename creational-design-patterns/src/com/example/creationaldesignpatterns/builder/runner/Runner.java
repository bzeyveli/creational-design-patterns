package com.example.creationaldesignpatterns.builder.runner;

import com.example.creationaldesignpatterns.builder.entity.User;

public class Runner {
	public static void main(String[] args) {
		
		User user = new User.UserBuilder().setTckn(123).setLastName("bekir").setSurName("zeyveli").build();
		System.out.println(user);
	}
}
