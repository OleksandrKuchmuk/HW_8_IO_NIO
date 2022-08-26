package com.cursor.Task2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Task2 {
    public static final Logger LOGGER = LogManager.getLogger(Task2.class);

    public static void main(String[] args) {

//      Compare reading and writing performance of usual and buffered reader for
//      200 MB file. Compare performance of buffered reader with different buffer size.

//      Read from file without buffer
        readFromFile200MbUnbuffered();

//      Read from file with buffer
        readFromFile200MbWithBuffer();
    }

    public static void readFromFile200MbUnbuffered() {
        Long startTime = System.currentTimeMillis();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("Apache.exe");
            int data = inputStream.read();
            while (data != -1) {
                data = inputStream.read();
            }
            inputStream.close();
        } catch (EOFException e) {
            LOGGER.info("EOF exception in readFromFile200MbUnbuffered()");
        } catch (IOException e) {
            LOGGER.info("IO Exception in input stream readFromFile200MbUnbuffered()");
        }
        Long stopTime = System.currentTimeMillis();
        LOGGER.info("File without buffer reads : " + (stopTime - startTime) + " milliseconds");
    }

    public static void readFromFile200MbWithBuffer() {
        DataInputStream dataInputStream = null;
        Long startTime = System.currentTimeMillis();
        try {
            dataInputStream = new DataInputStream(
                    new BufferedInputStream(
                            new FileInputStream("Apache.exe"), 16384));
            int data = dataInputStream.read();
            while (data != -1) {
                data = dataInputStream.read();
            }
            dataInputStream.close();
        } catch (EOFException e) {
            LOGGER.info("EOF exception in readFromFile200MbWithBuffer()");
        } catch (IOException e) {
            LOGGER.info("IO Exception in input stream readFromFile200MbWithBuffer()");
        }
        Long stopTime = System.currentTimeMillis();
        LOGGER.info("File with buffer (size 16384) reads : " + (stopTime - startTime) + " milliseconds");
    }
}