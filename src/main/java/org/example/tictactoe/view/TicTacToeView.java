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


}
