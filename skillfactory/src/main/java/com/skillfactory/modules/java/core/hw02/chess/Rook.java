package com.skillfactory.modules.java.core.hw02.chess;

public class Rook extends ChessPiece {

    public Rook(String color) {
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
        if (line != toLine && column == toColumn) {
            return true;
        }
        if (line == toLine && column != toColumn) {
            return true;
        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "R";
    }
}
