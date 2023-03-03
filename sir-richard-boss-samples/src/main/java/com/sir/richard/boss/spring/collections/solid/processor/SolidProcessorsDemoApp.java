package com.sir.richard.boss.spring.collections.solid.processor;

import org.springframework.boot.SpringApplication;

//@SpringBootApplication
public class SolidProcessorsDemoApp {

    public static void main(String[] args) {


        SpringApplication.run(SolidProcessorsDemoApp.class, args);
/*
        ApplicationContext context = new AnnotationConfigApplicationContext(SolidProcessorsDemoConfig.class);
        SolidProcessorsCollectionsBean collectionsBean = context.getBean(SolidProcessorsCollectionsBean.class);

        collectionsBean.printNameSet();
        collectionsBean.printBeans();
*/
    }
}
