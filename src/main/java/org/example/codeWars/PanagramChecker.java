package org.example.codeWars;


public class PanagramChecker {

    private static final char[] alphabet = new char[]{'A', 'B', 'C',
                                                      'D', 'E', 'F',
                                                      'G', 'H', 'I',
                                                      'J', 'K', 'L',
                                                      'M', 'N', 'O',
                                                      'P', 'Q', 'R',
                                                      'S', 'T', 'U',
                                                      'V', 'W', 'X',
                                                      'Y', 'Z'};

    public static void main(String[] args) {
        System.out.println(check("You shall not pass!"));
    }

    private static boolean check(String string) {
        if (string.length() < alphabet.length) {
            return false;
        }
        boolean res = false;
        for (int i = 0; i < alphabet.length; i++) {
            if (string.contains(Character.toString(alphabet[i]))) {
                res = false;
            } else {
                res = true;
            }
        }
        return res;
    }
}
