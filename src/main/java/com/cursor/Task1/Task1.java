package com.cursor.Task1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static final Logger LOGGER = LogManager.getLogger(Task1.class);

    public static void main(String[] args) throws Exception {

//        Write and read data to file using both Byte and Character streams.

//        Write to file (bytes):
        writeToFileBites();

//        Read from file (bytes):
        readFromFileBites();

//        Write to file (chars):
        writeToFileChars();

//        Read from file (chars):
        readFromFileChars();
    }

    public static void writeToFileBites() {
        try {
            OutputStream outputStream = new FileOutputStream("bites_stream_file.txt", true);
            String text = "\nHello to our program, it is a binary output stream";
            outputStream.write(text.getBytes());
            outputStream.close();
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException in Bites output stream");
        } catch (IOException e) {
            LOGGER.error("IOException in Bites output stream");
        }
    }

    public static void readFromFileBites() {
        String textFromFile = "";
        try {
            InputStream inputStream = new FileInputStream("bites_stream_file.txt");
            byte[] byteArray = inputStream.readAllBytes();
            textFromFile = new String(byteArray);
            inputStream.close();
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException in Bites input stream");
        } catch (IOException e) {
            LOGGER.error("IOException in Bites input stream");
        }
        LOGGER.info("From file we get: " + textFromFile);
    }

    public static void writeToFileChars() {
        try {
            FileWriter fileWriter = new FileWriter("character_stream_file.txt");
            String text = "\nHello, it is a character output stream\n";
            fileWriter.write(text);
            fileWriter.close();
        } catch (IOException e) {
            LOGGER.error("IOException in Chars output stream");
        }
    }


    public static void readFromFileChars(){
        FileReader fileReader;
        String text = "";
        try {
            fileReader = new FileReader("character_stream_file.txt");
            Scanner scanner = new Scanner(fileReader);
            int i = 1;
            while (scanner.hasNextLine()) {
                text += scanner.nextLine();
                i++;
            }
            fileReader.close();
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException in Chars input stream");
        } catch (IOException e) {
            LOGGER.error("IOException in Chars input stream");
        }
        LOGGER.info("From file we get: " + text);
    }
}