package org.example;

import java.io.*;

public class Writer {
    public static void PrintToConsole(Sudoku sudoku) {
        System.out.println("Решение заданного судоку:");
        String strSudoku = sudoku.toString();
        System.out.println(strSudoku);
    }

    public static void PrintToTextFile(Sudoku sudoku, String fileName, String message) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(sudoku.toString());
            writer.close();
            System.out.println(message);
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    public static void PrintToTextFile(Sudoku sudoku, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(sudoku.toString());
            writer.close();
            System.out.println("Запись судоку в текстовый файл завершена.");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл: " + e.getMessage());
        }
    }
}
