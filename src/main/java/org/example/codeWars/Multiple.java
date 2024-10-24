package org.example.codeWars;

import java.util.stream.IntStream;

public class Multiple {

    public static void main(String[] args) {
        System.out.println(solution(16));
        System.out.println(solution2(16));
    }

    // 3 + 5 + 6 + 9 + 10 + 12 + 15 = 60
    private static int solution(int number) {
        int multiplesCount = 0;

        for (int i = 1; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                multiplesCount += i;
            }
        }
        return multiplesCount;
    }

    private static int solution2(int number) {
        return IntStream
                .range(0, number)
                .filter(num -> (num % 3 == 0 || num % 5 ==0))
                .sum();
    }
}
