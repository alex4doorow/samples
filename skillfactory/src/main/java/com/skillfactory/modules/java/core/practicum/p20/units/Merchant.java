package com.skillfactory.modules.java.core.practicum.p20.units;

import com.skillfactory.modules.java.core.practicum.p20.artifacts.Goods;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Merchant extends AbstractUnit {

    public void sellQuestion(Goods goods, AbstractUnit hero) {
        System.out.println("Здорово, авантюрист!");
        if (goods == Goods.POTION) {
            System.out.println("Нужно зелье поправить здоровье? Хехе!");
            System.out.println(hero);
            System.out.println("Сколько зелья покупаешь? 1 золотой за 1 хилку. Введи число от 1 до " + hero.getGold());
        }
    }

    public synchronized void sell(Goods goods, AbstractUnit hero, int gold) {
        if (gold > hero.getGold()) {
            System.out.println("Get out, нахрен, нищеброд!");
            return;
        }
        if (gold <= 0) {
            System.out.println("Get out, нахрен, нищеброд!");
            return;
        }
        if (goods == Goods.POTION) {
            hero.setGold(hero.getGold() - gold);
            hero.setHealth(hero.getHealth() + gold);
            System.out.println("Покупка состоялась:");
            System.out.println(hero);
        }
    }

}
