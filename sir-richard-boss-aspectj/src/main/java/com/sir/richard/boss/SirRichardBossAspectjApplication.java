package com.sir.richard.boss;

//import com.sir.richard.boss.activemq.transport.failover.FailoverTransport;
import org.apache.activemq.transport.failover.FailoverTransport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

@SpringBootApplication
public class SirRichardBossAspectjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SirRichardBossAspectjApplication.class, args);
		//CustomerBo customerBo = new CustomerBo();
		//FailoverTransport failoverTransport = new FailoverTransport();
		//customerBo.addCustomer();
		//printName("Толя");
		//printName("Вова");
		//printName("Саша");
		String name = "Vasia";
		System.out.println("org.apache.commons.lang3.StringUtils.isNotEmpty: " + StringUtils.isNotEmpty(name));
		FailoverTransport failoverTransport = new FailoverTransport();
		try {
			failoverTransport.start();
			System.out.println("FailoverTransport: " + failoverTransport);

			SocketAddress endpoint = new InetSocketAddress("localhost/127.0.0.1", 5432);
			int timeOut = 10000;
			Socket socket = new Socket();
			socket.connect(endpoint, timeOut);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

	}

	public static void printName(String name) {
		System.out.println(name);
	}

}
