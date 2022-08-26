package com.cursor.Task4;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Task4 {
    public static final Logger LOGGER = LogManager.getLogger(Task4.class);

    public static void main(String[] args) {


//        Write a program that displays the contents of a specific directory (file and
//        folder names + their size) (use list for read folder content).

        File directory = new File("D:\\Music\\Music_for_test");
        File[] files = directory.listFiles();
        if (files != null && files.length > 0) {
            for (File file : files) {
                if (file.isDirectory()) {
                    LOGGER.info("Folder: " + file.getName());
                }else
                LOGGER.info("File: " + file.getName() + " (size in bytes: " + file.length() + ")");
            }
        }
    }
}