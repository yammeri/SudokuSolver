package org.example;

/* Задача для решения классического судоку 9x9 клеток
 * Судоку вводится частично заполненным, на месте пустых клеток ставится точка при вводе. При вводе судоку контролируется,
 * что введенные числа подчиняются правилам составления судоку (числа не повторяются по горизонтали, по вертикали
 * и в квадрате, в котором находятся). В качестве решения можно получить аналогично заполненное судоку,
 * но на месте пропусков будут подходящие под все правила числа, что и будет являться решением судоку. */

public class Main {
    public static void main(String[] args) {
        Sudoku sudoku = new Sudoku(Reader.GetSudokuFromKeyboard());

        Sudoku result = new Sudoku(Solver.solveSudoku(sudoku));

        System.out.println("-=".repeat(10));
        Writer.PrintToConsole(result);
    }
}
