package com.skillfactory.modules.java.core.hw02.chess;

public class Bishop extends ChessPiece {

    public Bishop(String color) {
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
        }
        int delta = Math.abs(line - toLine);
        int nToColumn1 = column + delta;
        int nToColumn2 = column - delta;
        if (nToColumn1 == toColumn || nToColumn2 == toColumn) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}

