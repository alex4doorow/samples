package org.example.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;

public class CalculatorApp {

    private static final Logger logger = LogManager.getLogger(CalculatorApp.class);
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        int i = sc.nextInt();
        logger.debug("Entered first num " + i);
        int j = sc.nextInt();
        logger.debug("Entered second num " + j);
        System.out.print("Enter a char: ");
        String k = sc.next();
        logger.debug("Entered char " + k);
        switch (k) {
            case "+":
                i = getSum(i, j);
                break;
            case "-":
                i = getSub(i, j);
                break;
            case "*":
                i = getMultiple(i, j);
                break;
            case "/":
                if (j == 0) {
                    logger.error("can't divide by zero");
                    i = 0;
                } else {
                    i = getDivide(i, j);
                }
                break;
        }
        logger.debug("result  " + i);
        System.out.println(i);
    }

    public static int getSum(int x, int y) {
        return x + y;
    }

    public static int getDivide(int x, int y) {
        return x / y;
    }

    public static int getMultiple(int x, int y) {
        return x * y;
    }

    public static int getSub(int x, int y) {
        return x - y;
    }

}
