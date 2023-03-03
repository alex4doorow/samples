package com.sir.richard.boss.spring.main.processor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class CheckingDbUpdateProcessors {

	/*
	@Autowired(required = false)
    @Qualifier("checkingDbUpdaterProcessors")
    private List<CheckingDbUpdaterProcessor> beans = new ArrayList<>();
    */

    public CheckingDbUpdateProcessors() {
    }
    
    public void printBeans() {
        //System.out.println(beans);
    }

}
