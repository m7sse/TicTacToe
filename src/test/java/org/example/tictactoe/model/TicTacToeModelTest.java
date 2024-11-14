package org.example.tictactoe.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeModelTest {

    private TicTacToeModel model;

    @BeforeEach
    void setUp() {
        model = new TicTacToeModel();
    }

    @Test
    void isValidMove() {
        assertTrue(model.isValidMove(0, 0), "Move at (0,0) should be valid on an empty board");
        model.makeMove(0, 0);
        assertFalse(model.isValidMove(0, 0), "Move at (0,0) should be invalid after being occupied");
        assertFalse(model.isValidMove(-1, 0), "Move outside the board (negative row) should be invalid");
        assertFalse(model.isValidMove(0, 3), "Move outside the board (column out of bounds) should be invalid");
    }

    @Test
    void makeMove() {
        assertTrue(model.makeMove(0, 0), "Making a move at (0,0) should appropriate");
        assertEquals('X', model.getBoard()[0][0], "The move at (0,0) should place 'X' on the board");
        assertFalse(model.makeMove(0, 0), "Making a move at (0,0) again should fail since it is occupied");
    }

    @Test
    void checkWinner() {
        model.makeMove(0, 0);
        model.makeMove(1, 0);
        model.makeMove(0, 1);
        model.makeMove(1, 1);
        model.makeMove(0, 2);
        assertTrue(model.checkWinner('X'));;
    }
}