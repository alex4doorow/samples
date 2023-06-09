package com.sir.richard.boss.activemq.transport.failover;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FailoverTransport {

    private static final Logger LOG = LoggerFactory.getLogger(FailoverTransport.class);

    public FailoverTransport() {
        doReconnect();
    }

    final boolean doReconnect() {
        //System.out.println("FailoverTransport doReconnect");
        LOG.info("FailoverTransport doReconnect");
        return false;
    }

}
