package org.example.tictactoe.model;

public class TicTacToeModel {
    private char[][] board; // Spelplanen (3x3 matris)
    private char player; // Aktuell spelare ('X' eller 'O')
    private int scoreX; // Poäng för spelare 'X'
    private int scoreO; // Poäng för spelare 'O'

    public TicTacToeModel() {
        board = new char[3][3]; // Initierar spelplanen
        player = 'X'; // Första spelaren är 'X'
        scoreX = 0; // Startpoäng för 'X'
        scoreO = 0; // Startpoäng för 'O'

        initializeBoard(); // fyller spelplanen med tomma rutor
    }

    private void initializeBoard() {
        for (int row = 0; row < 3; row++) { // loopa genom alla rader
            for (int col = 0; col < 3; col++) { // loopa genom alla kolumner
                board[row][col] = ' '; // sätter varje ruta till tom

            }
        }
    }

    public boolean isValidMove(int row, int col) {
        // kollar om en ruta är inom gränserna och tom
        return row >= 0 && col >= 0 && row < 3 && col < 3 && board[row][col] == ' ';
    }

    public boolean makeMove(int row, int col) {
        if (isValidMove(row, col)) { // om draget är giltigt
            board[row][col] = player; // placera spelarens symbol på rutan
            if (checkWinner(player)) { // kolla om spelaren vann
                if (player == 'X') {
                    scoreX++; // öka poängen för 'X'
                } else {
                    scoreO++; // öka poängen för 'O'
                }
                return true; // spelaren vann
            }
            player = (player == 'X') ? 'O' : 'X'; // byt till nästa spelare
            return true;
        }
        return false;
    }

    public boolean checkWinner(char symbol) {
        // kolla rader och kolumner
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) || // en rad
                    (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol)) { // en kolumn
                return true; // det finns en vinnande linje
            }
        }
        // Kolla diagonaler
        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) || // diagonal från vänster
                (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol);   // diagonal från höger
    }

    public boolean isDraw() {
        // kolla om alla rutor är fyllda utan vinnare
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == ' ') { // om en ruta är tom
                    return false; // ingen oavgjord
                }
            }
        }
        return true; // alla rutor är fyllda
    }

    public void resetBoard() {
        initializeBoard(); // nollställ spelplanen
        player = 'X'; // starta om med X
    }

    public int getScoreX() {
        return scoreX; // returnerar poängen för X
    }

    public int getScoreO() {
        return scoreO; // returnerar poängen för O
    }

    public char getPlayer() {
        return player; // returnerar aktuell spelare
    }

    public char[][] getBoard() {
        return board; // returnerar spelplanen
    }
}
