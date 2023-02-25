package com.skillfactory.modules.java.core.m06.l02.l4;

public class Main {

    public static void main(String[] args) {

        Zombie zombie1 = new Zombie("Alice");
        zombie1.growl();
        zombie1.growl(true);
        zombie1.growl(false);


/*
This fragment of code has to output

Monster Alice the Zombie was created
Raaaauuughhhh Alice the Zombie growled
RAAAAUUUGHHHH Alice the Zombie growled
Raaaauuughhhh Alice the Zombie growled

*/
    }

}
