package ru.skillfactory.demo.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// https://github.com/SkillfactoryCoding/JAVA-Spring-skillfactory_bot/blob/master/src/main/resources/application.properties
@EnableScheduling
@SpringBootApplication
public class TgbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgbotApplication.class, args);
	}

}
