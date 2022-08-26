package com.cursor.Task6;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SomeBuffer {
    public static final Logger LOGGER = LogManager.getLogger(SomeBuffer.class);
    private static FileChannel fileChannel;
    private static ByteBuffer byteBuffer;


    public static Path readPath() {
        return Paths.get("buffer.txt");
    }

    public static void writeToChanel(Path path, String message) {
        try {
            fileChannel = FileChannel.open(Paths.get(
                    String.valueOf(path)), StandardOpenOption.WRITE);
            byteBuffer = ByteBuffer.wrap(message.getBytes());
            fileChannel.write(byteBuffer);
            LOGGER.info("\nWrite: " + message);
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException in writeToChanel() ");
        } catch (IOException e) {
            LOGGER.error("IOException in writeToChanel() ");
        }
    }

    public static void readFromChanel(Path path) {
        String readFromChannel = "";
        try {
            fileChannel = FileChannel.open(Paths.get(String.valueOf(path)));
            byteBuffer = ByteBuffer.allocate(1024);
            while (fileChannel.read(byteBuffer) != -1) {
                byteBuffer.flip();
                while (byteBuffer.hasRemaining()) {
                    readFromChannel += ((char) byteBuffer.get());
                }
                byteBuffer.clear();
            }
            LOGGER.info("\nRead: " + readFromChannel);
        } catch (FileNotFoundException e) {
            LOGGER.error("FileNotFoundException in readFromChanel() ");
        } catch (IOException e) {
            LOGGER.error("IOException in readFromChanel() ");
        }
    }
}