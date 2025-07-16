package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Reader {
    private static final Logger logger = LogManager.getLogger(Reader.class);
    public static char[][] GetSudokuFromKeyboard() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите частично заполненное судоку");
        PrintRules();

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

    public static char[][] GetSudokuFromFile() {
        char[][] resBoard = new char[Sudoku.MAX_LENGTH][Sudoku.MAX_LENGTH];
        String fileName = InputExistFileName();

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

    private static void PrintRules() {
        System.out.println("Судоку состоит из 9 строк, каждая строка содержит 9 символов, символы разделяются одним пробелом");
        System.out.println("На места незаполненных ячеек вводится символ '.'");
        System.out.println("Допустимые символы: цифры от 1 до 9 и '.'");
    }

    private static String InputExistFileName() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите имя текстового файла для чтения судоку");

        String curFileName = null;
        boolean isExist = false;

        while (!isExist) {
            curFileName = sc.nextLine();
            File curFile = new File(curFileName);
            isExist = curFile.exists();
            if (!isExist) {
                logger.info("Попытка ввода имени несуществующего файла для чтения, запрошен повтор ввода");
                System.out.println("Файла с таким именем не существует. Повторите ввод...");
            }
        }
        logger.info("Успешный ввод имени файла");
        return curFileName;
    }
}
