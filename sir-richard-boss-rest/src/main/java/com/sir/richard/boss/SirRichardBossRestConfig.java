package com.sir.richard.boss;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"com.sir.richard.boss"})
@EntityScan("com.sir.richard.boss.bl.entity")
@EnableJpaRepositories(basePackages = "com.sir.richard.boss.bl.jpa")
public class SirRichardBossRestConfig {


}
