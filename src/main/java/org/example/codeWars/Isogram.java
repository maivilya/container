package org.example.codeWars;


import java.util.Arrays;

public class Isogram {

    public static void main(String[] args) {
        System.out.println(isIsogram("moOse"));
        System.out.println(isIsogram2("moOse"));
    }

    private static boolean isIsogram(String string) {
        char[] stringToChar = string.toLowerCase().toCharArray();
        Arrays.sort(stringToChar);
        for (int i = 0; i < stringToChar.length; i++) {
            try {
                if (stringToChar[i] == stringToChar[i + 1]) {
                    return false;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                return true;
            }
        }
        return true;
    }

    private static boolean isIsogram2(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
