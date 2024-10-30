package org.example.tictactoe.model;

import java.util.Arrays;

public class TicTacToeModel {
    private char[][] board;
    private char player;

    public TicTacToeModel() {
        board = new char[3][3];
        player = 'X';
        initializeBoard();
    }

    private void initializeBoard(){
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';

            }
        }
    }
    private boolean isValidMove(int row, int col){
        return row >= 0 && col >= 0 && row < 3 && col < 3 && board[row][col] == ' ';
    }

}

