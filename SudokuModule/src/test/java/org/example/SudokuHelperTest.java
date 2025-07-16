package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SudokuHelperTest {

    @Test
    void isValid_InColumn() {
        int[][] sudokuBox = new int[Sudoku.MAX_LENGTH][Sudoku.MAX_LENGTH];

        for (int i =0; i < Sudoku.MAX_LENGTH; i++) {
            sudokuBox[i][0] = i;
        }

        Assertions.assertFalse(SudokuHelper.isValid(sudokuBox, 0, 0, 8));
    }

    @Test
    void isValid_InRow() {
        int[][] sudokuBox = new int[Sudoku.MAX_LENGTH][Sudoku.MAX_LENGTH];

        for (int i =0; i < Sudoku.MAX_LENGTH; i++) {
            sudokuBox[0][i] = i;
        }

        Assertions.assertFalse(SudokuHelper.isValid(sudokuBox, 0, 0, 8));
    }

    @Test
    void isCorrectLine_CorrectLine() {
        char[] nums = new char[] {'.', '2', '3', '4', '5', '6', '7', '8', '9'};
        Assertions.assertTrue(SudokuHelper.isCorrectLine(nums));
    }

    @Test
    void isCorrectLine_IncorrectLine() {
        char[] nums = new char[] {'.', '2', '3', '4', '5', '6', '7', '8'};
        Assertions.assertFalse(SudokuHelper.isCorrectLine(nums));
        nums = new char[] {'1', '2', 'a', '4', '5', '6', '7', '8', '9'};
        Assertions.assertFalse(SudokuHelper.isCorrectLine(nums));
    }
}