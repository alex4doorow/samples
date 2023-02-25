package com.skillfactory.modules.java.core.m10.t1021;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
/*

Make byte InputStream OneZeroStream, which gives
1 0 1 0 .....

*/
        Scanner scanner = new Scanner(new OneZeroStream());
        for (int i = 0; i < 10; i++){
            System.out.print(scanner.nextInt());
        }

/*

The code above has to output

1010101010

*/
    }

}
