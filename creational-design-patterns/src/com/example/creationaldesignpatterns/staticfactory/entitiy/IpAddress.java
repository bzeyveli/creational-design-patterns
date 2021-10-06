package com.example.creationaldesignpatterns.staticfactory.entitiy;

import java.text.MessageFormat;
import java.util.Random;

import com.example.creationaldesignpatterns.staticfactory.constant.RandomFormat;

public final class IpAddress {

	private String ipv4Address;
	private String ipv6Address;
	static Random random = new Random();

	public IpAddress(String ipv4Address, String ipv6Address) {

		this.ipv4Address = ipv4Address;
		this.ipv6Address = ipv6Address;
	}

	public static IpAddress ipv4() {
//StringBuilder builder =  new StringBuilder();
//		builder.append('a').append('z').append(random.nextInt(127));
		String ipv4Address1;
		int[] ipv4 = new int[8];
		for (int i = 0; i < ipv4.length; i++) {
			ipv4[i] = random.nextInt(127);
		}
		ipv4Address1 = MessageFormat.format(RandomFormat.ipv4, ipv4[0], ipv4[1], ipv4[2], ipv4[3]);
		return new IpAddress(ipv4Address1, "null");
	}

	public static IpAddress ipv6() {

		// ipv6 adresleri 128 bit uzunlugundadýr. burda 60 bit olarak düþündüm.

		String ipv6Address1;
		int[] ipv6 = new int[36];
		for (int i = 0; i < ipv6.length; i++) {
			ipv6[i] = random.nextInt(4999) * 2;
		}
		ipv6Address1 = MessageFormat.format(RandomFormat.ipv6, ipv6[0], ipv6[1], ipv6[2], ipv6[3], ipv6[4], ipv6[5],
				ipv6[6], ipv6[7], ipv6[8]);

		return new IpAddress("null", ipv6Address1);
	}

	@Override
	public String toString() {
		return "IpAddress [ipv4Address=" + ipv4Address + ", ipv6Address=" + ipv6Address + "]";
	}

}
