package com.skillfactory.modules.java.core.practicum.p20.units;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Skeleton extends Monster {

    public Skeleton() {
        super();
        this.name = "sceleton";

        this.health = 15;
        this.force = 20;
        this.agility = 20;

        this.xp = 20;
        this.gold = 10;
    }
}
