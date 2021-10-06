package com.example.creationaldesignpatterns.staticfactory.runner;

import com.example.creationaldesignpatterns.staticfactory.entitiy.IpAddress;

public class Runner {
	public static void main(String[] args) {
		
		
		IpAddress ipAddress1 = IpAddress.ipv4();
		IpAddress ipAddress2 = IpAddress.ipv6();
		
		System.out.println("ipv4 : " + ipAddress1);
		 System.out.println("ipv6 : " + ipAddress2);
		
		  
	
	}
}
