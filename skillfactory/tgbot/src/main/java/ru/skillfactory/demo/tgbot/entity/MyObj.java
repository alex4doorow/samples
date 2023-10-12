package ru.skillfactory.demo.tgbot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MyObj {

    @Id
    @SequenceGenerator(name = "TG_SEQUENCE", sequenceName = "TG_SEQUENCE", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TG_SEQUENCE")
    @Column(name = "ID", updatable = false)
    private Long id;

    @Column(name = "MESSAGE")
    private String message;
}
