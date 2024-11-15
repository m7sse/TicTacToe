package org.example.tictactoe.model;

public class TicTacToeModel {
    private char[][] board;
    private char player;
    private int scoreX;
    private int scoreO;

    public TicTacToeModel() {
        board = new char[3][3];
        player = 'X';
        scoreX = 0;
        scoreO = 0;

        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                board[row][col] = ' ';
            }
        }
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && col >= 0 && row < 3 && col < 3 && board[row][col] == ' ';
    }

    public boolean makeMove(int row, int col) {
        if (isValidMove(row, col)) {
            board[row][col] = player;
            if (checkWinner(player)) {
                if (player == 'X') {
                    scoreX++;
                } else {
                    scoreO++;
                }
                return true;
            }
            player = (player == 'X') ? 'O' : 'X';
            return true;
        }
        return false;
    }

    public boolean checkWinner(char symbol) {
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) ||
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) {
                return true;
            }
        }
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);
    }

    public boolean isDraw() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }


    public void resetBoard() {
        initializeBoard();
        player = 'X';
    }

    public int getScoreX() {
        return scoreX;
    }

    public int getScoreO() {
        return scoreO;
    }

    public char getPlayer() {
        return player;
    }

    public char[][] getBoard() {
        return board;
    }
}
