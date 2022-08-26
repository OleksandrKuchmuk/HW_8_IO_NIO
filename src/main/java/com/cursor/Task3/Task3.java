package com.cursor.Task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task3 {
    public static final Logger LOGGER = LogManager.getLogger(Task3.class);
    private static String inputDataString;

    public static void main(String[] args) {

//      Write a program that reads a Java source-code file (you provide the file
//      name on the command line) and displays to console all the comments in file.

//      Read data from file.
        readJavaSourceCodeFileAndWriteToString(args[0]);

//      search for and display comments from the String that was made from Java source-code file.
        searchAndDisplayComments(inputDataString);


    }

    public static void readJavaSourceCodeFileAndWriteToString(String fileName) {
        File file = new File(fileName);

        try {
            try (InputStream in = new FileInputStream(file))
            {
                byte[] bytes  = new byte[(int)file.length()];

                int offset = 0;
                while (offset < bytes.length)
                {
                    int result = in.read(bytes, offset, bytes.length - offset);
                    if (result == -1) {
                        break;
                    }
                    offset += result;
                }
                inputDataString = new String(bytes, StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
           LOGGER.info("IOException in readJavaSourceCodeFileAndWriteToString()");
        }
    }


    public static void searchAndDisplayComments(String inputString){
String[] strings = inputString.split("\n");
        for (String s:strings) {
            if (s.startsWith("//")){
                LOGGER.info(s);
            }
        }
    }
}