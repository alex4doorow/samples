package ru.skillfactory.demo.tgbot.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "TG_ACTIVE_CHAT")
public class ActiveChat {

    @Id
    @SequenceGenerator(name = "TG_SEQUENCE", sequenceName = "TG_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TG_SEQUENCE")
    @Column(name = "ID", updatable = false)
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId; //Уникальный идентификатор в системе Telegram
}
