package com.skillfactory.modules.java.core.hw02.hw0208;

public class Warrior extends Player {
    String armor;

    public Warrior(int hp, int level, String type, String weapon, String armor) {
        super(hp, level, type, weapon);
        this.armor = armor;
    }

    @Override
    public String getFullInfo() {
        return hp + " " + level + " " + type + " " + weapon + " " + armor;
    }

    @Override
    public void levelUp() {
        level++;
    }

    @Override
    public boolean doDamage() {
        return true;
    }
}
