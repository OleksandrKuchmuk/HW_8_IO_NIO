package com.cursor.Task6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task6 {
    public static final Logger LOGGER = LogManager.getLogger(Task6.class);
    private static String message = "Some message from Alex";


    public static void main(String[] args) {

//  Try to create SomeBuffer class, which can be used for read and write data from/to channel (Java NIO)
  SomeBuffer.writeToChanel(SomeBuffer.readPath(), message);
  SomeBuffer.readFromChanel(SomeBuffer.readPath());
    }
}