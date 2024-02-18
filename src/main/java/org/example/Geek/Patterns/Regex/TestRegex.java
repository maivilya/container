package org.example.Geek.Patterns.Regex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegex {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        checkXMLTeg();
        match();
        match2();
        match3();
    }

    /**
     * В этом методы мы ищем все соответствия в тексте,
     * считаем их количество и выводим их на экран
     */
    private static void match3() {
        List<String> languages = Arrays.asList("java", "C", "c++", "c#", "javascript", "scala", "Sova");
        Pattern pattern = Pattern.compile("^[c\\-Cs\\-S]");
        languages.stream().filter(pattern.asPredicate()).forEach(System.out::println);
    }

    /**
     * В этом методы мы ищем все соответствия в тексте,
     * выводим их на экран, а так же выводим на экран
     * индекс начала и индекс конца соответствия.
     */
    private static void match2() {
        String s = scanner.nextLine();
        Pattern pattern = Pattern.compile("apple");
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
            System.out.println("Found [" + matcher.group() + "], start: "
                    + matcher.start() + "; end: " + (matcher.end() - 1));
        }
    }

    /**
     * В этом методы мы ищем все соответствия в тексте,
     * считаем их количество и выводим их на экран
     */
    private static void match() {
        String regex = "кот\\b";
        String text = "котенок котяра кот котел кот байкот";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        while (matcher.find()) {
            System.out.println(matcher.group());
            count++;
        }
        System.out.println(count);
    }

    /**
     * В этом методе мы проверяем XML на правильное написание,
     * а точнее вложенность тегов и расположение контента в них
     */
    private static void checkXMLTeg() {
        /* test teg
         * <h1>Nayeem loves counseling</h1>
         * <h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
         * <Amee>safat codes like a ninja</amee>
         * <SA premium>Imtiaz has a secret crush</SA premium>
         */
        final String regex = "<([^>]+)>([^<>]+)</\\1>";
        Pattern pattern = Pattern.compile(regex);
        int countLines = Integer.parseInt(scanner.nextLine());
        Matcher matcher;
        while (countLines > 0) {
            String line = scanner.nextLine();
            matcher = pattern.matcher(line);
            boolean isFind = true;
            while (matcher.find()) {
                System.out.println(matcher.group(2));
                isFind = false;
            }
            if (isFind) {
                System.out.println("Not valid");
            }
            countLines--;
        }
    }
}
