package com.sir.richard.boss.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value="classpath:application.properties", encoding="UTF-8")
//@ImportResource({"${app.beans-xml-path}"})
public class AppConfig {
}
