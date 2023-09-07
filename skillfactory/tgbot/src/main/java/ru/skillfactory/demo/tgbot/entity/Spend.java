package ru.skillfactory.demo.tgbot.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "TG_SPEND")
@Data
public class Spend {

    @Id
    @SequenceGenerator(name = "TG_SEQUENCE", sequenceName = "TG_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TG_SEQUENCE")
    @Column(name = "ID", updatable = false)
    private Long id;

    @Column(name = "CHAT_ID")
    private Long chatId;

    @Column(name = "SPEND")
    private BigDecimal spend;
}
