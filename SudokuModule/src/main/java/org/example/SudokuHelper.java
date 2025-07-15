package org.example;

public class SudokuHelper {
    static private final String CORRECT_SYMBOLS = "123456789.";
    public static boolean isValid(int[][] sudokuBox, int rowNum, int colNum, int num) {
        boolean notInColumn = true;
        for (int i = 0; i < Sudoku.MAX_LENGTH && notInColumn; i++) {
            if (sudokuBox[i][colNum] != 0 && i != rowNum) {
                notInColumn = num != sudokuBox[i][colNum];
            }
        }

        boolean notInRow = true;
        for (int j = 0; j < Sudoku.MAX_LENGTH && notInRow; j++) {
            if (sudokuBox[rowNum][j] != 0 && j != colNum) {
                notInRow = num != sudokuBox[rowNum][j];
            }
        }

        boolean notInBox = true;
        int boxRowNum = rowNum / Sudoku.BOX_LENGTH * Sudoku.BOX_LENGTH;
        int boxColNum = colNum / Sudoku.BOX_LENGTH * Sudoku.BOX_LENGTH;
        for (int i = boxRowNum; i < boxRowNum + Sudoku.BOX_LENGTH && notInBox; i++) {
            for (int j = boxColNum; j < boxColNum + Sudoku.BOX_LENGTH && notInBox; j++) {
                if (sudokuBox[i][j] != 0 && i != rowNum && j != colNum) {
                    notInBox = num != sudokuBox[i][j];
                }
            }
        }

        return notInColumn && notInRow && notInBox;
    }

    public static boolean isCorrectLine(char[] nums) {
        if (nums.length != Sudoku.MAX_LENGTH) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!CORRECT_SYMBOLS.contains(String.valueOf(nums[i]))) {
                return false;
            }
        }

        return true;
    }
}
