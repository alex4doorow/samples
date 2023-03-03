package com.sir.richard.boss.spring.main.processor.impl;

import com.sir.richard.boss.model.exceptions.CoreException;
import com.sir.richard.boss.spring.main.processor.CheckingDbUpdaterProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckingForCreateDbUpdaterProcessor implements CheckingDbUpdaterProcessor {
    
    public CheckingForCreateDbUpdaterProcessor() {
    }

    @Override
    public void process() throws CoreException {
    	log.info("process: {}",  this.getClass().getName());        
    }

    public String toString() {
        return "{" + this.getClass().toString() +"}";
    }
}