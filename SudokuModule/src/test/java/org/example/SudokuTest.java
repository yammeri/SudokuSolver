package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SudokuTest {
    private Sudoku sudoku;

    @BeforeEach
    void setUp() {
        sudoku = new Sudoku();
    }

    @Test
    void getBoard() {
        Assertions.assertArrayEquals(new int[Sudoku.MAX_LENGTH][Sudoku.MAX_LENGTH], sudoku.getBoard());
    }

    @Test
    void getSudokuElem() {
        Assertions.assertEquals(0, sudoku.getSudokuElem(Sudoku.MAX_LENGTH - 1, Sudoku.MAX_LENGTH - 1));
    }

    @Test
    void testToString() {
        String expRes = ((". ").repeat(Sudoku.MAX_LENGTH - 1) + ".\n").repeat(Sudoku.MAX_LENGTH);
        Assertions.assertEquals(expRes, sudoku.toString());
    }
}