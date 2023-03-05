package com.sir.richard.boss.spring.collections.solid.processor;

import com.sir.richard.boss.spring.collections.baeldung.BaeldungBean;
import com.sir.richard.boss.spring.collections.solid.processor.impl.CheckingForCreateDbUpdaterProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SolidProcessorsCollectionsBean {

    private Set<String> nameSet;

    @Autowired(required = false)
    @Qualifier("solidProcessors")
    private List<CheckingDbUpdaterProcessor> beanList = new ArrayList<>();

    public SolidProcessorsCollectionsBean() {
    }

    public SolidProcessorsCollectionsBean(Set<String> names) {
        this.nameSet = names;
    }

    public void printNameSet() {
        System.out.println(nameSet);
    }

    public void printBeans() {
        System.out.println(beanList);
    }


}
