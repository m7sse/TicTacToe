package org.example.tictactoe.model;

import java.util.Random;

public class Computer {
    private char symbol; // Datorns symbol
    private Random random = new Random(); //slumpa drag

    public Computer(char symbol) {
        this.symbol = symbol; // Sätter datorns symbol
    }

    public void makeMove(TicTacToeModel model) {
        int row, col;
        do {
            row = random.nextInt(3); // Slumpa rad (0-2)
            col = random.nextInt(3); // Slumpa kolumn (0-2)
        } while (!model.isValidMove(row, col)); // Kontrollera att draget är giltigt

        model.makeMove(row, col); // Utför draget
    }

    public char getSymbol() {
        return symbol; // Returnerar datorns symbol
    }
}
