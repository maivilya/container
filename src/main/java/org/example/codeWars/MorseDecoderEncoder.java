package org.example.codeWars;

import java.util.HashMap;
import java.util.Map;

public class MorseDecoderEncoder {

    private static final Map<String, String> morseAlphabet =  new HashMap<>();

    static {
        morseAlphabet.put("A", ".-");
        morseAlphabet.put("B", "-...");
        morseAlphabet.put("C", "-.-.");
        morseAlphabet.put("D", "-..");
        morseAlphabet.put("E", ".");
        morseAlphabet.put("F", "..-.");
        morseAlphabet.put("G", "--.");
        morseAlphabet.put("H", "....");
        morseAlphabet.put("I", "..");
        morseAlphabet.put("J", ".---");
        morseAlphabet.put("K", "-.-");
        morseAlphabet.put("L", ".-..");
        morseAlphabet.put("M", "--");
        morseAlphabet.put("N", "-.");
        morseAlphabet.put("O", "---");
        morseAlphabet.put("P", ".--.");
        morseAlphabet.put("Q", "--.-");
        morseAlphabet.put("R", ".-.");
        morseAlphabet.put("S", "...");
        morseAlphabet.put("T", "-");
        morseAlphabet.put("U", "..-");
        morseAlphabet.put("V", "...-");
        morseAlphabet.put("W", ".--");
        morseAlphabet.put("X", "-..-");
        morseAlphabet.put("Y", "-.--");
        morseAlphabet.put("Z", "--..");
        morseAlphabet.put("1", ".----");
        morseAlphabet.put("2", "..---");
        morseAlphabet.put("3", "...--");
        morseAlphabet.put("4", "....-");
        morseAlphabet.put("5", ".....");
        morseAlphabet.put("6", "-....");
        morseAlphabet.put("7", "--...");
        morseAlphabet.put("8", "---..");
        morseAlphabet.put("9", "----.");
        morseAlphabet.put("0", "-----");
        morseAlphabet.put("!", "-.-.--");
        morseAlphabet.put(".", ".-.-.-");
    }

    public static void main(String[] args) {
        System.out.println(decode(".... . -.--   .--- ..- -.. ."));
        System.out.println(decode("... --- ... -.-.--  - .... .  --.- ..- .. -.-. -.-  -... .-. --- .-- -.  ..-. --- -..-  .--- ..- -- .--. ...  --- ...- . .-.  - .... .  .-.. .- --.. -.--  -.. --- --. .-.-.-"));
    }

    private static String decode(String morseCode) {
        StringBuilder decodedMorseCode = new StringBuilder();
        String[] wordsMorseCode = morseCode.split("  ");
        for (String wordMorseCode : wordsMorseCode) {
            if (decodedMorseCode.length() > 0) {
                decodedMorseCode.append(" ");
            }
            String[] lettersMorseCode = wordMorseCode.split(" ");
            for (String letterMorseCode : lettersMorseCode) {
                String letter = getLetter(letterMorseCode);
                if (letter != null) {
                    decodedMorseCode.append(letter);
                }
            }
        }
        return decodedMorseCode.toString();
    }

    private static String getLetter(String letterMorseCode) {
        for (Map.Entry<String, String> entry : morseAlphabet.entrySet()) {
            if (entry.getValue().equalsIgnoreCase(letterMorseCode)) {
                return entry.getKey();
            }
        }
        return null;
    }
}
