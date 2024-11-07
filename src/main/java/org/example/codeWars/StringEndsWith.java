package org.example.codeWars;

public class StringEndsWith {
    public static void main(String[] args) {
        System.out.println(solution("samurai", "ai"));
        System.out.println(solution("sumo", "omo"));
        System.out.println(solution("ninja", "ja"));
        System.out.println(solution("sensei", "i"));
        System.out.println(solution("samurai", "ra"));
        System.out.println(solution("abc", "abcd"));
        System.out.println(solution("abc", "abc"));
        System.out.println(solution("abcabc", "bc"));
        System.out.println(solution("ails", "fails"));
        System.out.println(solution("fails", "ails"));
        System.out.println(solution("this", "fails"));
        System.out.println(solution("this", ""));
        System.out.println(solution(":-)", ":-("));
        System.out.println(solution("!@#$%^&*() :-)", ":-)"));
        System.out.println(solution("abc\n", "abc"));
    }

    private static boolean solution(String string, String ending) {
        if (ending.length() > string.length()) {
            return false;
        }
        return string.substring(string.length() - ending.length()).contains(ending);
    }
}
