package com.skillfactory.modules.java.core.m04a;

public class SeaBoardMain {
    public static void main(String[] args) {
        SeaBoard board = new SeaBoard();
        board.shoot(0, 0, "m");
        board.shoot(2, 0, "h");
        board.shoot(6, 9, "h");
        board.shoot(2, 1, "d");
        for (int i = 0; i < board.getField().length; i++) {
            for (int j = 0; j < board.getField()[0].length; j++) {
                System.out.print(board.getField()[i][j] + " ");
            }
            System.out.println();
        }
    }
}
