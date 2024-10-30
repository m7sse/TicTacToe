package org.example.tictactoe.model;

import java.util.Arrays;

public class TicTacToeModel {
    char[][] board = new char[3][3];
    private char player = 'X';

    public TicTacToeModel() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            Arrays.fill(board[i], ' ');
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3;
    }

    public void makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = player;
            player = (player == 'X') ? 'O' : 'X';
        }
    }

    public boolean checkWinner() {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') ||
                    (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ')) {
                return true;
            }
        }
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ');
    }

}

