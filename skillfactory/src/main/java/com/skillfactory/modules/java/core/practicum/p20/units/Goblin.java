package com.skillfactory.modules.java.core.practicum.p20.units;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Goblin extends Monster {

    public Goblin() {
        super();
        this.name = "goblin";
        this.health = 50;
        this.force = 10;
        this.agility = 10;

        this.xp = 100;
        this.gold = 20;
    }
}
