package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Writer {
    private static final Logger logger = LogManager.getLogger(Writer.class);
    public static void PrintToConsole(Sudoku sudoku) {
        System.out.println("Решение заданного судоку:");
        String strSudoku = sudoku.toString();
        System.out.println(strSudoku);
        logger.info("Судоку напечатано на экран");
    }

    public static void PrintToTextFile(Sudoku sudoku) {
        String fileName = InputNotExistFileName();

        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(sudoku.toString());
            writer.close();

            String mes = "Запись в файл " + fileName + " завершена";
            logger.info(mes);
            System.out.println(mes);
        } catch (IOException e) {
            String mes = "Ошибка записи в файл: " + e.getMessage();
            logger.error(mes);
            System.out.println(mes);
        }
    }
    private static String InputNotExistFileName() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите имя нового текстового файла для записи данных");

        String curFileName = null;
        boolean isExist = true;

        while (isExist) {
            curFileName = sc.nextLine();
            File curFile = new File(curFileName);
            isExist = curFile.exists();
            if (isExist) {
                logger.info("Попытка ввода имени существующего файла для записи, запрошен повтор ввода");
                System.out.println("Файл с таким именем уже существует. Повторите ввод...");
            }
        }
        logger.info("Успешный ввод имени файла");
        return curFileName;
    }

}
