package com.skillfactory.modules.java.core.practicum.p20;

import com.skillfactory.modules.java.core.practicum.p20.artifacts.Goods;
import com.skillfactory.modules.java.core.practicum.p20.units.*;
import org.apache.commons.lang3.StringUtils;

import java.util.Random;
import java.util.Scanner;

public class GamingWorld {

    private int gamingStep;

    public GamingWorld() {

    }

    public void game() throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя:");
        String heroName = sc.next();

        heroName = "Aragorn";
        System.out.println("Вы ввели имя: " + heroName + ", start...");

        Hero hero = new Hero(heroName);
        while (true) {
            System.out.println("Куда пойдешь? (1- торговец, 2- темный лес, 3- выход):");
            gamingStep = sc.nextInt();

            if (gamingStep == 1) {
                welcomeToMarketplace(sc, hero);
            } else if (gamingStep == 2) {
                Random random = new Random();
                int typeMonster = random.nextInt(Integer.MAX_VALUE);

                Monster monster;
                if (typeMonster % 2 == 0) {
                    monster = new Skeleton();
                } else {
                    monster = new Goblin();
                }
                System.out.println("Встретил монстра: " + monster.getClass().getSimpleName());
                fight(hero, monster);
                if (hero.isDead()) {
                    System.out.println("Помер. Game is over");
                    return;
                }
                if (monster.isDead()) {
                    System.out.println("Победа!");
                }

            } else if (gamingStep == 3) {
                System.out.println("Пока!");
                return;
            }
        }
    }

    private void welcomeToMarketplace(Scanner sc, Hero hero) {
        Merchant merchant = new Merchant();
        merchant.sellQuestion(Goods.POTION, hero);
        int inputGold = sc.nextInt();
        merchant.sell(Goods.POTION, hero, inputGold);
    }

    private void fight(Hero hero, Monster monster) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            try {

                System.out.println("Мочилово начато");
                int i = 1;
                while (true) {
                    System.out.println("round: " + i);
                    if (!hero.isDead()) {
                        hero.hit(monster);
                    }
                    if (!monster.isDead()) {
                        monster.hit(hero);
                    }
                    if (hero.isDead() || monster.isDead()) {
                        break;
                    }
                    Thread.sleep(200);
                    i++;
                }
                System.out.println(hero);
                if (monster.isAlive()) {
                    System.out.println("Monster: " + monster);
                }
                System.out.println("Мочилово завершено");

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        t1.start();
        t1.join();
    }
}
