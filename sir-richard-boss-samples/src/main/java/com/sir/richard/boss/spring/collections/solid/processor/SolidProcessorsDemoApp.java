package com.sir.richard.boss.spring.collections.solid.processor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SolidProcessorsDemoApp {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(SolidProcessorsDemoConfig.class);
        SolidProcessorsCollectionsBean collectionsBean = context.getBean(SolidProcessorsCollectionsBean.class);
        collectionsBean.printNameSet();
        collectionsBean.printBeans();


    }
}
