package com.sir.richard.boss.spring.main.jmx;

import com.sir.richard.boss.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class SystemUserService {

    @Autowired
    private JmsTemplate jmsTemplate;

    @PostConstruct
    public void init() {
        log.info("Sending an email message: {}", "Hello");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
    }
}
