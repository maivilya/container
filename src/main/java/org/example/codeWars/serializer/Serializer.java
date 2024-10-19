package org.example.codeWars.serializer;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Serializer {
    public static void main(String[] args) {
        // #region serialize
        /**
         * TODO: serialize user
         */

        // #region deserialize
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            fileInputStream = new FileInputStream("testFile.txt");
            objectInputStream = new ObjectInputStream(fileInputStream);
            User deserializeMe = (User)objectInputStream.readObject();
            System.out.println(deserializeMe);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
