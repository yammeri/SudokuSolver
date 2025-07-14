package org.example;

public class Solver {
    public static int[][] solveSudoku(Sudoku sudoku) {
        return solveSudoku(0, 0, sudoku.getBoard());
    }

    private static int[][] solveSudoku(int rowNum, int colNum, int[][] sudokuBox) {
        if (rowNum == Sudoku.MAX_LENGTH) {
            return sudokuBox;
        }

        if (colNum == Sudoku.MAX_LENGTH) {
            return solveSudoku(rowNum + 1, 0, sudokuBox);
        }

        if (sudokuBox[rowNum][colNum] != 0) {
            return solveSudoku(rowNum, colNum + 1, sudokuBox);
        }

        for (int i = 1; i <= Sudoku.MAX_LENGTH; i++) {
            if (SudokuHelper.isValid(sudokuBox, rowNum, colNum, i)) {
                sudokuBox[rowNum][colNum] = i;
                if (solveSudoku(rowNum, colNum + 1, sudokuBox) != null) {
                    return sudokuBox;
                }
                sudokuBox[rowNum][colNum] = 0;
            }
        }

        return null;
    }
}
