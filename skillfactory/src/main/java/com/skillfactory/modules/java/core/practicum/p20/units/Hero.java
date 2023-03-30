package com.skillfactory.modules.java.core.practicum.p20.units;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Setter
@Getter
public class Hero extends AbstractUnit {


    public Hero(String name) {
        super();
        this.name = name;
        this.health = 100;
        this.force = 20;
        this.agility = 20;

        this.xp = 0;
        this.gold = 0;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public synchronized void hit(AbstractUnit visavi) {

        Random random = new Random();
        int kForceAttack = random.nextInt(100);

        int localForce;
        if (this.agility * 3 > kForceAttack) {
            localForce = force;
        } else {
            localForce = 0;
            System.out.println(this.getName() + " пропускает удар!");
        }
        if (localForce > 0) {
            visavi.health = visavi.health - localForce;
            showInfoAfterHit(this, visavi, localForce);
        }
        if (visavi.isDead()) {
            System.out.println("Победа! " + visavi.getName() + " замочен! Получаешь: " + visavi.gold + " золота и " + visavi.xp + " опыта");
            this.gold += visavi.gold;
            this.xp += visavi.xp;

            visavi.gold = 0;
            visavi.xp = 0;
        }
    }

    public void addFrag(Monster monster) {
        frags.add(monster);
    }

    public void showTotal() {
        System.out.println("Повержено врагов: " + frags.size());
        long skeletonsCount = frags.stream().filter(monster -> monster instanceof Skeleton).count();
        long goblinsCount = frags.stream().filter(monster -> monster instanceof Goblin).count();
        System.out.println(" - скелетов: " + skeletonsCount);
        System.out.println(" - гоблинов: " + goblinsCount);
        System.out.println("---------------");
    }
}
