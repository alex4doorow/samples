package com.skillfactory.modules.java.core.practicum.p20.units;

import java.util.Random;

public abstract class Monster extends AbstractUnit {

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
            this.gold += visavi.gold;
            this.xp += visavi.xp;

            visavi.gold = 0;
            visavi.xp = 0;
        }
    }
}
