package org.example.tictactoe.view;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TicTacToeView {
    private GridPane boardGrid; // layout för spelbrädet
    private Button[][] buttons; // array med knappar för varje ruta

    public TicTacToeView() {
        boardGrid = new GridPane(); //  GridPane för att visa spelbrädet
        buttons = new Button[3][3]; // en 3x3-knapparray

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button(""); // Skapar en tom knapp
                button.setMinSize(100, 100); // Sätter knappens storlek
                boardGrid.add(button, col, row); // Lägger till knappen i GridPane
                buttons[row][col] = button; // Sparar knappen i arrayen
            }
        }
    }

    public GridPane getBoardGrid() {
        return boardGrid;
    }

    public Button getButtons(int row, int col) {
        return buttons[row][col]; // returnerar specifik knapp från brädet
    }

    public void updateButton(int row, int col, char playerSymbol) {
        buttons[row][col].setText(String.valueOf(playerSymbol)); // uppdaterar knappens text med spelarens symbol
    }
}
