package com.sir.richard.boss.spring.collections.solid.processor;

import com.sir.richard.boss.spring.collections.solid.processor.impl.CheckingForCreateDbUpdaterProcessor;
import com.sir.richard.boss.spring.collections.solid.processor.impl.CheckingForUpdateDbUpdaterProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class SolidProcessorsDemoConfig {

    @Bean
    @Order(1)
    @Qualifier("solidProcessors")
    public CheckingDbUpdaterProcessor getCreatingProcessorOne() {
        return new CheckingForCreateDbUpdaterProcessor("first");
    }

    @Bean
    @Order(2)
    @Qualifier("solidProcessors")
    public CheckingDbUpdaterProcessor getCreatingProcessorTwo() {
        return new CheckingForUpdateDbUpdaterProcessor("second");
    }

    @Bean
    @Order(3)
    @Qualifier("solidProcessors")
    public CheckingDbUpdaterProcessor getCreatingProcessorThree() {
        return new CheckingForCreateDbUpdaterProcessor("third");
    }

    @Bean
    @Qualifier("solidProcessors")
    public SolidProcessorsCollectionsBean getSolidProcessorsCollectionsBean() {
        return new SolidProcessorsCollectionsBean(new HashSet<>(Arrays.asList("first", "second", "third")));
    }

}
