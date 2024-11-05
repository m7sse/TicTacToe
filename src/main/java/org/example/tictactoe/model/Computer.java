package org.example.tictactoe.model;

import java.util.Random;

public class Computer {
    private char symbol;
    private Random random = new Random();

    public Computer(char symbol) {
        this.symbol = symbol;
    }
    public void makeMove (TicTacToeModel model){
        int row, col;
        do {
            row = random.nextInt(3);
            col = random.nextInt(3);
        }while (!model.isValidMove(row, col));

        model.makeMove(row, col);
    }
    public char getSymbol() {
        return symbol;
    }
}
