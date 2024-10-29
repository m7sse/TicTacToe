package org.example.tictactoe.model;

import java.util.Arrays;

public class TicTacToeModel {
    char[][] board = new char[3][3];
    private char player = 'X';

    public TicTacToeModel() {
        initializeBoard();
    }

    private void initializeBoard(){
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
    }

    public void makeMove(int row, int col){
        board[row][col] = player;
        player = (player == 'X') ? 'O' : 'X';
    }
}

