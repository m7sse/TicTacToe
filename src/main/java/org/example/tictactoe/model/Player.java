package org.example.tictactoe.model;

public class Player {
    private char symbol;

    public Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public void makeMove(TicTacToeModel model, int row, int col) {
        if (model.isValidMove(row, col)) {
            model.makeMove(row, col);
        }
    }
}
