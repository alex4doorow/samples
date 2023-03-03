package com.sir.richard.boss.spring.main.processor;

import com.sir.richard.boss.model.exceptions.CoreException;

public interface DbUpdaterProcessor {	
    void process() throws CoreException;
}
