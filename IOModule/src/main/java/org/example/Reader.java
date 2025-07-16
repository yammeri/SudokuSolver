package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Reader {
    private static final Logger logger = LogManager.getLogger(Reader.class);
    public static char[][] getSudokuFromKeyboard() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите частично заполненное судоку");
        printRules();

        char[] bufNums;
        char[][] resBoard = new char[Sudoku.MAX_LENGTH][Sudoku.MAX_LENGTH];
        for (int i = 0; i < Sudoku.MAX_LENGTH; i++) {
            while (!SudokuHelper.isCorrectLine(bufNums = sc.nextLine().replaceAll(" ", "").toCharArray())) {
                logger.info("Попытка ввода некорректной строки, запрошен повтор ввода");
                System.out.println("Была введена строка неправильного формата, пожалуйста, повторите ввод");
            }
            for (int j = 0; j < bufNums.length; j++) {
                resBoard[i][j] = bufNums[j];
            }
        }
        logger.info("Данные успешно прочитаны");
        return resBoard;
    }

    public static char[][] getSudokuFromFile() {
        char[][] resBoard = new char[Sudoku.MAX_LENGTH][Sudoku.MAX_LENGTH];
        String fileName = (new IOHelper()).inputExistFileName();

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
            String mes = "Данные успешно прочитаны из файла " + fileName;
            logger.info(mes);
            System.out.println(mes);
        }
        catch (IOException e) {
            String mes = "Ошибка чтения файла: " + e.getMessage();
            logger.error(mes);
            System.out.println(mes);
        }
        return resBoard;
    }

    private static void printRules() {
        System.out.println("Судоку состоит из 9 строк, каждая строка содержит 9 символов, символы разделяются одним пробелом");
        System.out.println("На места незаполненных ячеек вводится символ '.'");
        System.out.println("Допустимые символы: цифры от 1 до 9 и '.'");
    }
}
