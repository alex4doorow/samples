package com.skillfactory.modules.java.core.hw02.chess;

public class Pawn extends ChessPiece {

    public Pawn(String color) {
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
        } else if (column != toColumn) {
            return false;
        } else if (color.equalsIgnoreCase("White") && line == 1 && (toLine == 2 || toLine == 3)) {
            return true;
        } else if (color.equalsIgnoreCase("Black") && line == 6 && (toLine == 5 || toLine == 4)) {
            return true;
        } else if (color.equalsIgnoreCase("White") && line > 1 && toLine == (line + 1)) {
            return true;
        } else if (color.equalsIgnoreCase("Black") && line < 5 && toLine == (line - 1)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
