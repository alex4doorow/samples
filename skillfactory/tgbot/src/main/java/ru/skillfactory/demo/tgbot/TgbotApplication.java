package ru.skillfactory.demo.tgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// https://github.com/SkillfactoryCoding/JAVA-Spring-skillfactory_bot/blob/master/src/main/resources/application.properties
// собеседование https://apps.skillfactory.ru/learning/course/course-v1:SkillFactory+JAVA-14M+2021/block-v1:SkillFactory+JAVA-14M+2021+type@sequential+block@43649331122b4487954be96650b00bb8/block-v1:SkillFactory+JAVA-14M+2021+type@vertical+block@e7cffc1a372b40be8398dfdc67b7793a
@EnableScheduling
@SpringBootApplication
public class TgbotApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgbotApplication.class, args);
	}

}
