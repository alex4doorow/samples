package com.skillfactory.modules.java.core.m15.t545;

import java.util.Optional;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(getGuessResult(4));

    }

    public static Optional<String> getGuessResult(int guess) {
/*
        Напишите такой метод, который принимает 1 параметр типа int guess (догадка) в диапазоне от 1 до 5
        и возвращает Optional<String> (выигрыш). Внутри метода реализуйте следующую логику:
        если передаваемый guess не в требуемом диапазоне — бросайте IllegalStateException;
        иначе: генерируйте рандомное значение int (для этого вам понадобится метод nextInt(int bound) класса java.util.Random);
        если сгенерированное значение равняется переданному значению guess, тогда возвращайте Optional.of(“Поздравляем!
        Вы угадали значение!”));
        если же нет — Optional.empty().
*/
        if (guess < 1 || guess > 5) {
            throw new IllegalStateException("1..5");
        }
        Random random = new Random();
        int nextInt = random.nextInt(guess);
        Optional<String> result;
        if (nextInt == guess) {
            result = Optional.of("Поздравляем! Вы угадали значение!");
        } else {
            result = Optional.empty();
        }
        return result;
    }
}
