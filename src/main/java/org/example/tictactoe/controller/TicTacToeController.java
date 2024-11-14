package org.example.tictactoe.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.tictactoe.model.Computer;
import org.example.tictactoe.model.Player;
import org.example.tictactoe.model.TicTacToeModel;

public class TicTacToeController {
    @FXML
    private Label welcomeText;
    private TicTacToeModel model;
    private Player playerX;
    private Computer computerO;
    private Button[][] buttons = new Button[3][3];

    @FXML
    private Label resultLabel;

    public void setGameParameters(TicTacToeModel model, Player playerX, Computer computerO) {
        this.model = model;
        this.playerX = playerX;
        this.computerO = computerO;
    }

    @FXML
    public void initialize() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                String buttonId = "button" + row + col;
                buttons[row][col] = (Button) welcomeText.getScene().lookup("#" + buttonId);
                final int r = row;
                final int c = col;
                buttons[row][col].setOnAction(event -> handleButtonClick(r,c));
            }
        }
    }

    private void handleButtonClick(int row, int col) {
        if (model.makeMove(row, col)) {
            buttons[row][col].setText(String.valueOf(playerX.getSymbol()));
            if (isGameFinished()) {
                updateResult();
                return;
            }
            computerO.makeMove(model);
            updateComputerMove();
            if (isGameFinished()) {
                updateResult();
            }
        }
    }

    private void updateComputerMove() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (model.getBoard()[row][col] == computerO.getSymbol()) {
                    buttons[row][col].setText(String.valueOf(computerO.getSymbol()));
                    return;
                }
            }
        }
    }

    private boolean isGameFinished() {
        if (model.checkWinner(playerX.getSymbol())) {
            return true;
        } else if (model.checkWinner(computerO.getSymbol())) {
            return true;
        } else if (model.isDraw()) {
            return true;
        }
        return false;
    }

    private void updateResult() {
        if (model.checkWinner(playerX.getSymbol())) {
            resultLabel.setText("Player X Wins!");
        } else if (model.checkWinner(computerO.getSymbol())) {
            resultLabel.setText("Computer O Wins!");
        } else if (model.isDraw()) {
            resultLabel.setText("It's a Draw!");
        }


        resultLabel.setText(resultLabel.getText() + " Player X: " + model.getScoreX() + " - Player O: " + model.getScoreO());
        model.resetBoard();
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
