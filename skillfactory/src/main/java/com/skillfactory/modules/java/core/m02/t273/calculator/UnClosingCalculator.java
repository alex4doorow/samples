package com.skillfactory.modules.java.core.m02.t273.calculator;

import lombok.Data;

import java.util.Arrays;
import java.util.Scanner;

public class UnClosingCalculator {

    public static void main(String[] args) {
        System.out.println("Это калькулятор. Нужно ввести последовательно: первое число, затем знак" +
                " операции, и затем второе число. Если надоело, наберите символ 's'. Если хотите сбросить результат наберите 'c'");
        for (String s : Arrays.asList("Операции могут быть только: + - * /", "Начинайте ввод на одну строчку ниже этого текста:")) {
            System.out.println(s);
        }
        Scanner scanner = new Scanner(System.in);
        char managerWork = 'c';
        double temporaryResult = 0;
        double operand1;
        char operation;
        double operand2;

        do {
            if (managerWork == 'c') {
                System.out.println("Введите новые данные:");
                operand1 = scanner.nextDouble(); //считывает первое число
                operation = scanner.next().charAt(0); // условие
            } else {
                operand1 = temporaryResult; //считывает первое число
                operation = managerWork;
            }

            operand2 = scanner.nextDouble(); //считывает второе число
            System.out.println("Делаем: " + operand1 + " " + operation + " " + operand2);
            CalculateResult result = calculate(operand1, operand2, operation);
            // вывод ответа на экран
            if (result.getStatus() == CalculateStatuses.DivideByZero) {
                System.out.println("Вы ошиблись! Попытка деления на ноль. Попробуйте снова!");
            } else if (result.getStatus() == CalculateStatuses.OperationIsNotSupported) {
                System.out.println("Вы ввели операцию, которую калькулятор не поддерживает: " + operation
                        + "! Повторите попытку");
            }  else {
                System.out.println("Ответ: " + result.getResult());
                temporaryResult = result.getResult();
            }
            managerWork = scanner.next().charAt(0);
        } while (managerWork != 's');
    }

    public static CalculateResult calculate(double operand1, double operand2, char operation) {
        CalculateResult result = new CalculateResult();

        switch (operation) {
            case '+' -> result.setResult(operand1 + operand2);
            case '-' -> result.setResult(operand1 - operand2);
            case '*' -> result.setResult(operand1 * operand2);
            case '/' -> {
                if (operand2 == 0) {
                    // "Подстава! Ввели ноль - делить не будем"
                    result.setStatus(CalculateStatuses.DivideByZero);
                    break;
                }
                result.setResult(operand1 / operand2);
            }
            default -> result.setStatus(CalculateStatuses.OperationIsNotSupported);
        }
        return result;
    }

    @Data
    public static class CalculateResult {
        public double result = 0;
        public CalculateStatuses status = CalculateStatuses.OK;
    }
}
