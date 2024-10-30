package org.example.tictactoe.view;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class TicTacToeView {
    private GridPane boardGrid;
    private Button[][] buttons;

    public TicTacToeView() {
        boardGrid = new GridPane();
        buttons = new Button[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                Button button = new Button("");
                button.setMinSize(100, 100);
                boardGrid.add(button, col, row);
                buttons[row][col] = button;
            }
        }
    }
    public GridPane getBoardGrid() {
        return boardGrid;
    }
    public Button getButtons(int row, int col) {
        return buttons[row][col];
    }
    public void updateButton (int row, int col, char playerSymbol) {
        buttons[row][col].setText(String.valueOf(playerSymbol));
    }

}
