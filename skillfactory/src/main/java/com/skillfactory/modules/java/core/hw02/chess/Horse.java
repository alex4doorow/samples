package com.skillfactory.modules.java.core.hw02.chess;

public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 0 || toLine > 7 || toColumn < 0 || toColumn > 7) {
            return false;
        } else if (toLine == line && toColumn == column) {
            return false;
        } else if (Math.abs(line - toLine) == 1 && Math.abs(column - toColumn) == 2) {
            return true;
        } else if (Math.abs(line - toLine) == 2 && Math.abs(column - toColumn) == 1) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
