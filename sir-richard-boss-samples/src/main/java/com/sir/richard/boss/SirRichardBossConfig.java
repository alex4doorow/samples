package com.sir.richard.boss;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

import com.sir.richard.boss.spring.main.processor.CheckingDbUpdaterProcessor;
import com.sir.richard.boss.spring.main.processor.impl.CheckingForCreateDbUpdaterProcessor;
import com.sir.richard.boss.spring.main.processor.impl.CheckingForUpdateDbUpdaterProcessor;

@Configuration
@ComponentScan(basePackages = {"com.sir.richard.boss.spring.main"})
@ImportResource({"${app.beans-xml-path}"})
public class SirRichardBossConfig {




    @Bean
	@Order(1)
    @Qualifier("checkingDbUpdaterProcessors")
    public CheckingDbUpdaterProcessor getCreatingProcessorOne() {
        //return new CheckingForCreateDbUpdaterProcessor("first");
        return new CheckingForCreateDbUpdaterProcessor();
    }
	
	@Bean
	@Order(2)
    @Qualifier("checkingDbUpdaterProcessors")
    public CheckingDbUpdaterProcessor getCreatingProcessorTwo() {
        //return new CheckingForUpdateDbUpdaterProcessor("second");
        return new CheckingForUpdateDbUpdaterProcessor();
    }

    /*
		
	@Bean
    @Qualifier("checkingDbUpdaterProcessorsAA")
    public com.diximonline.upd.processor.CheckingDbUpdaterProcessor getCreatingProcessorAA() {
        return new com.diximonline.upd.processor.impl.CheckingForCreateDbUpdaterProcessor();
    }	

	@Bean
    @Qualifier("checkingDbUpdaterProcessorsAA")
    public com.diximonline.upd.processor.CheckingDbUpdaterProcessor getCreatingProcessorAB() {
        return new com.diximonline.upd.processor.impl.CheckingForUpdateDbUpdaterProcessor();
    }
    */

}
