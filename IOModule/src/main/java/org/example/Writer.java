package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Writer {
    private static final Logger logger = LogManager.getLogger(Writer.class);

    public static boolean printToConsole(Sudoku sudoku) {
        try {
            System.out.println("Решение заданного судоку:");
            String strSudoku = sudoku.toString();
            System.out.println(strSudoku);
            logger.info("Судоку напечатано на экран");
            return true;
        } catch (Exception e) {
            String mes = "Ошибка печати на консоль: " + e.getMessage();
            logger.error(mes);
            System.out.println(mes);
            return false;
        }
    }

    public static boolean printToTextFile(Sudoku sudoku) {
        String fileName = (new IOHelper()).inputNotExistFileName();
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(sudoku.toString());
            writer.close();

            String mes = "Запись в файл " + fileName + " завершена";
            logger.info(mes);
            System.out.println(mes);
            return true;
        } catch (IOException e) {
            String mes = "Ошибка записи в файл: " + e.getMessage();
            logger.error(mes);
            System.out.println(mes);
            return false;
        }
    }
}
