package org.example;

import java.util.InputMismatchException;

public class Sudoku {
    static public final int MAX_LENGTH = 9;
    static public final int BOX_LENGTH = 3;

    private final int[][] board;

    public Sudoku(char[][] inputArr) {
        board = new int[MAX_LENGTH][MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                if (inputArr[i][j] == '.') {
                    board[i][j] = 0;
                } else {
                    board[i][j] = Character.getNumericValue(inputArr[i][j]);
                    if (!SudokuHelper.isValid(board, i, j, board[i][j])) {
                        Exception e = new InputMismatchException();
                        System.out.println("Невозможно создать судоку, введены неккорректные данные: " + e.getMessage());
                    }
                }
            }
        }
    }

    public Sudoku(int[][] inputArr) {
        board = new int[MAX_LENGTH][MAX_LENGTH];
        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                board[i][j] = inputArr[i][j] - '0';
                if (!SudokuHelper.isValid(board, i, j, board[i][j])) {
                    throw new InputMismatchException();
                }
            }
        }
    }


    public int[][] getBoard() {
        return board;
    }

    public int getSudokuElem(int i, int j) {
        return board[i][j];
    }

    @Override
    public String toString() {
        String res = "";
        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                if (board[i][j] == 0) {
                    res += ".";
                } else {
                    res += String.valueOf(board[i][j]);
                }
                if (j < MAX_LENGTH - 1) {
                    res += " ";
                } else {
                    res += "\n";
                }
            }
        }
        return res;
    }
}

