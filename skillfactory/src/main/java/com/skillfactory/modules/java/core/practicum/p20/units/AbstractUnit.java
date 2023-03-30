package com.skillfactory.modules.java.core.practicum.p20.units;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class AbstractUnit {

    protected String name = "unknown";

    protected int health; // здоровье
    protected int xp; // опыт
    protected int gold; // золото
    protected int force; // сила
    protected int agility; // ловкость

    protected List<Monster> frags = new ArrayList<>();

    protected void showInfoAfterHit(AbstractUnit atacker, AbstractUnit defender, int localForce) {
        System.out.printf("%s нанес удар в %d единиц!%n", atacker.getName(), localForce);
        System.out.printf("У %s осталось %d единиц здоровья...%n", defender.getName(), defender.getHealth());
    }

    public synchronized void hit(AbstractUnit visavi) {
        // ....
    }

    public String getName() {
        return this.getClass().getSimpleName();
    }

    public boolean isDead() {
        return health <= 0;
    }

    public boolean isAlive() {
        return health > 0;
    }

    @Override
    public String toString() {
        String textHealth = ", health=" + this.health;
        if (health <= 0) {
            textHealth = ", помер";
        }
        String fragsTotal = "";
        if (frags.size() > 0) {
            fragsTotal = ", frags=" + frags.size();
        }
        return "Unit {" +
                "name='" + this.getName() + '\'' +
                textHealth +
                ", experience=" + xp +
                ", gold=" + gold +
                fragsTotal +
                //", force=" + force +
                //", agility=" + agility +
                '}';
    }
}
