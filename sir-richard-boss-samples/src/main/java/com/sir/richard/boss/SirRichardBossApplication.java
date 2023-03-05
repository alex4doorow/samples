package com.sir.richard.boss;

import com.sir.richard.boss.model.Email;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.jms.core.JmsTemplate;

@SpringBootApplication
public class SirRichardBossApplication {
    //poms https://spring.io/guides/gs/multi-module/

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SirRichardBossApplication.class, args);
/*
        JmsTemplate jmsTemplate = context.getBean(JmsTemplate.class);
        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
 */
    }
}