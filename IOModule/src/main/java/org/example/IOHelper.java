package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.util.Scanner;

public class IOHelper {
    private static final Logger logger = LogManager.getLogger(Reader.class);
    public String inputNotExistFileName() {
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

    public String inputExistFileName() {
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
