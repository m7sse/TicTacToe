package org.example.tictactoe.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.example.tictactoe.model.Computer;
import org.example.tictactoe.model.Player;
import org.example.tictactoe.model.TicTacToeModel;

public class TicTacToeController {
    @FXML
    private Label welcomeText;
    private TicTacToeModel model; // spelets modell
    private Player playerX; // spelare X
    private Computer computerO; // datorn som spelar som O
    private Button[][] buttons = new Button[3][3]; // knappfält för spelplanen
    public Button button00;
    public Button button01;
    public Button button02;
    public Button button10;
    public Button button11;
    public Button button12;
    public Button button20;
    public Button button21;
    public Button button22;

    @FXML
    private Label resultLabel;

    public void setGameParameters(TicTacToeModel model, Player playerX, Computer computerO) {
        this.model = model; // kopplar modellen
        this.playerX = playerX; // kopplar spelare X
        this.computerO = computerO; // kopplar datorn
    }

    @FXML
    public void initialize() {
        // initierar spelet genom att koppla knapparna i spelplanen
        buttons[0][0] = button00;
        button00.setOnAction(event -> handleButtonClick(0, 0));
        buttons[0][1] = button01;
        button01.setOnAction(event -> handleButtonClick(0, 1));
        buttons[0][2] = button02;
        button02.setOnAction(event -> handleButtonClick(0, 2));
        buttons[1][0] = button10;
        button10.setOnAction(event -> handleButtonClick(1, 0));
        buttons[1][1] = button11;
        button11.setOnAction(event -> handleButtonClick(1, 1));
        buttons[1][2] = button12;
        button12.setOnAction(event -> handleButtonClick(1, 2));
        buttons[2][0] = button20;
        button20.setOnAction(event -> handleButtonClick(2, 0));
        buttons[2][1] = button21;
        button21.setOnAction(event -> handleButtonClick(2, 1));
        buttons[2][2] = button22;
        button22.setOnAction(event -> handleButtonClick(2, 2));



    }

    private void handleButtonClick(int row, int col) {
        if (model.makeMove(row, col)) { // om spelaren gör ett giltigt drag
            buttons[row][col].setText(String.valueOf(playerX.getSymbol())); // uppdatera knappen med X, som är spelarens symbol
            if (isGameFinished()) { // kolla om spelet är slut
                updateResult(); // uppdatera resultatet
                return;
            }
            computerO.makeMove(model); // datorn gör sitt drag
            updateComputerMove(); // uppdatera datorns drag på brädet
            if (isGameFinished()) { // kolla igen om spelet är slut
                updateResult(); // uppdatera resultatet
            }
        }
    }

    private void updateComputerMove() {
        // hitta och uppdatera den ruta där datorn gjorde sitt drag
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (model.getBoard()[row][col] == computerO.getSymbol()) { // om rutan har datorns symbol
                    buttons[row][col].setText(String.valueOf(computerO.getSymbol())); // uppdatera knappens text
                    return;
                }
            }
        }
    }

    private boolean isGameFinished() {
        // kontrollera om någon har vunnit eller om det är oavgjort
        if (model.checkWinner(playerX.getSymbol())) { // om spelare X vann
            return true;
        } else if (model.checkWinner(computerO.getSymbol())) { // om datorn vann
            return true;
        } else if (model.isDraw()) { // om det är oavgjort
            return true;
        }
        return false; // spelet är inte slut
    }

    private void updateResult() {
        // visa resultatmeddelande beroende på vem som vann eller om det är oavgjort
        if (model.checkWinner(playerX.getSymbol())) {
            resultLabel.setText("Player X Wins!");
        } else if (model.checkWinner(computerO.getSymbol())) {
            resultLabel.setText("Computer O Wins!");
        } else if (model.isDraw()) {
            resultLabel.setText("It's a Draw!");
        }

        // lägg till poängstatus i resultatet
        resultLabel.setText(resultLabel.getText() + " Player X: " + model.getScoreX() + " - Player O: " + model.getScoreO());
        model.resetBoard(); // nollställ spelplanen för ett nytt spel

        //Reset text on buttons to empty string
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                buttons[row][col].setText("");
            }
        }


    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void handleModeSelection(ActionEvent actionEvent) {

    }

    public void handleButtonClick(ActionEvent actionEvent) {
    }

    public void resetBoard(ActionEvent actionEvent) {


    }

    public void resetGame(ActionEvent actionEvent) {


    }
}
