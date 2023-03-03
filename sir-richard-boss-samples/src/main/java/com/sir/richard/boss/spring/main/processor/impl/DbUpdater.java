package com.sir.richard.boss.spring.main.processor.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.sir.richard.boss.model.exceptions.CoreException;
import com.sir.richard.boss.spring.main.processor.CheckingDbUpdaterProcessor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class DbUpdater {
	
	@Autowired
    @Qualifier("checkingDbUpdaterProcessors")
    private List<CheckingDbUpdaterProcessor> checkingDbUpdaterProcessors = new ArrayList<>();
	
	//@Autowired
	//CheckingDbUpdateProcessors checkingDbUpdateProcessors;
	
	@Autowired(required = false)
    @Qualifier("checkingDbUpdaterProcessorsAA")
    private List<com.diximonline.upd.processor.CheckingDbUpdaterProcessor> checkingDbUpdaterProcessorsAA = new ArrayList<>();
		
	@PostConstruct
	public void init() {
		log.info("updatingDb.start, {}", checkingDbUpdaterProcessors);
		
		try {
			checking();
			//checkingDbUpdaterProcessorsAA.process();
			log.info(checkingDbUpdaterProcessorsAA.toString());
		} catch (Exception ex) {
			// TODO Auto-generated catch block
			log.error("Exception:", ex);
            //initiateShutdown(-1);
        } finally {
        	log.info("updatingDb.finish");	
        }    	
	}
	
	private void checking() throws CoreException {		
		for (CheckingDbUpdaterProcessor processor : checkingDbUpdaterProcessors) {
			processor.process();
		}
	}

}
