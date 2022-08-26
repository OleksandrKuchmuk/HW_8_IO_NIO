package com.cursor.Task5;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Task5 {
    public static final Logger LOGGER = LogManager.getLogger(Task5.class);

    public static void main(String[] args) {

//        Create custom class User with fields name (String type), age (int type), credentials (custom class).
//        Credentials has to be object with fields login and password. Serialize and deserialize it. Use transient.

        User user = new User("Alex", 40, new Credentials("alex_login", "Alex_password_2508"));
        String path = "testFile.txt";
        LOGGER.info("Initial User: " + user);
        serialize(user, path);
        User loadedUser = deserialize(path);
        LOGGER.info("Loaded User from file: " + loadedUser);

    }

    static void serialize(User user, String path) {
        FileOutputStream outputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            outputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(user);
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException in serialize()");
        } catch (IOException e) {
            LOGGER.error("IOException in serialize()");
        } finally {
            try {
                if (objectOutputStream != null) {
                    objectOutputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("IOException: Can`t close stream");
            }
        }
    }

    static User deserialize(String path) {
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            return (User) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            LOGGER.error("\"FileNotFoundException in deserialize()\"");
        } catch (IOException e) {
            LOGGER.error("IOException in deserialize()");
        } catch (ClassNotFoundException e) {
            LOGGER.error("ClassNotFoundException in deserialize()");
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (objectInputStream != null) {
                    objectInputStream.close();
                }
            } catch (IOException e) {
                LOGGER.error("IOException in deserialize: Can`t close stream");
            }
        }
        return null;
    }
}