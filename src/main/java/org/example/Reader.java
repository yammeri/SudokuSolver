package org.example;

import java.io.*;
import java.util.Scanner;

public class Reader {
    public static char[][] GetSudokuFromKeyboard() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите частично заполненное судоку");
        PrintRules();

        char[] bufNums;
        char[][] resBoard = new char[Sudoku.MAX_LENGTH][Sudoku.MAX_LENGTH];
        boolean isValidSudoku = true;
        for (int i = 0; i < Sudoku.MAX_LENGTH; i++) {
            while (!SudokuHelper.isCorrectLine(bufNums = sc.nextLine().replaceAll(" ", "").toCharArray())) {
                System.out.println("Была введена строка неправильного формата, пожалуйста, повторите ввод");
            }
            for (int j = 0; j < bufNums.length; j++) {
                resBoard[i][j] = bufNums[j];
            }
        }
        return resBoard;
    }

    public static char[][] GetSudokuFromFile(String fileName) {
        char[][] resBoard = new char[Sudoku.MAX_LENGTH][Sudoku.MAX_LENGTH];

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            char[] bufNums;
            int i = 0;
            while ((line = reader.readLine()) != null) {
                bufNums = line.replaceAll(" ","").toCharArray();
                if (!SudokuHelper.isCorrectLine(bufNums)) {
                    return null;
                }
                for (int j = 0; j < bufNums.length; j++) {
                    resBoard[i][j] = bufNums[j];
                }
                i++;
            }
            System.out.println("Данные успешно прочитаны из файла.");
        }
        catch (IOException e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
        return resBoard;
    }

    private static void PrintRules() {
        System.out.println("Судоку состоит из 9 строк, каждая строка содержит 9 символов, символы разделяются одним пробелом");
        System.out.println("На места незаполненных ячеек вводится символ '.'");
        System.out.println("Допустимые символы: цифры от 1 до 9 и '.'");
    }
}
