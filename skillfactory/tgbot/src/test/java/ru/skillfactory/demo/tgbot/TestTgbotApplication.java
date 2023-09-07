package ru.skillfactory.demo.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;

@TestConfiguration(proxyBeanMethods = false)
public class TestTgbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgbotApplication.class, args);
	}

}
