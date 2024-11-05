package org.example.tictactoe.model;

import java.util.Random;

public class Computer {
    private char symbol;
    private Random random = new Random();

    public Computer(char symbol) {
        this.symbol = symbol;
    }

}
