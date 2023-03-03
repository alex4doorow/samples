package com.sir.richard.boss.spring.main.processor.impl;

import com.sir.richard.boss.model.exceptions.CoreException;
import com.sir.richard.boss.spring.main.processor.CheckingDbUpdaterProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckingForUpdateDbUpdaterProcessor implements CheckingDbUpdaterProcessor {
    
    public CheckingForUpdateDbUpdaterProcessor() {
    }

    @Override
    public void process() throws CoreException {
    	log.info("process: {}",  this.getClass().getName());
    	/*
    	throw new CoreException(CoreException.CONFIG_ERROR,
                "Your jar is older than the installed current version of the database - take a new archive");
                */
    }

    public String toString() {
        return "{" + this.getClass().toString() + "}";
    }
}
