package com.sir.richard.boss.bo;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

public class CustomerBo {

    //private static final Logger LOG = LoggerFactory.getLogger(CustomerBo.class);

    public CustomerBo() {
        doReconnect();
    }

    public void addCustomer() {
        System.out.println("addCustomer() is running");
        //LOG.info("addCustomer() is running ");
    }

    public String addCustomerReturnValue() {
        System.out.println("addCustomerReturnValue() is running ");
        return "abc";
    }

    public void addCustomerThrowException() throws Exception {
        System.out.println("addCustomerThrowException() is running ");
        throw new Exception("Generic Error");
    }

    public void addCustomerAround(String name) {
        System.out.println("addCustomerAround() is running, args : " + name);
    }

    final boolean doReconnect() {
        System.out.println("doReconnect");
        return true;
    }
}
