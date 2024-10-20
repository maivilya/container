package org.example.codeWars;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Дан массив целых чисел, найдите то, которое встречается нечетное количество раз.
 * Всегда будет только одно целое число, которое встречается нечетное количество раз.
 * Примеры
 * [7]должно вернуться 7, потому что оно встречается 1 раз (что нечетно).
 * [0]должно вернуться 0, потому что оно встречается 1 раз (что нечетно).
 * [1,1,2]должно вернуться 2, потому что оно встречается 1 раз (что нечетно).
 * [0,1,0,1,0]должно вернуться 0, потому что оно встречается 3 раза (что нечетно).
 * [1,2,2,3,3,3,4,3,3,3,2,2,1]должно вернуться 4, потому что оно встречается 1 раз (что нечетно).
 */

public class FindOdd {
    public static void main(String[] args) {
        long currentTimeMillis = System.currentTimeMillis();
        int[] array = new int[]{1, 1, 2, 4, 4, 3, 1, 1, 3, 3, 3, 4, 4, 2, 2};
        System.out.println(findIt(array));
        System.out.println("Completed time(1) = " + (System.currentTimeMillis() - currentTimeMillis));

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(findIt2(array));
        System.out.println("Completed time(2) = " + (System.currentTimeMillis() - currentTimeMillis));

        currentTimeMillis = System.currentTimeMillis();
        System.out.println(findIt3(array));
        System.out.println("Completed time(3) = " + (System.currentTimeMillis() - currentTimeMillis));
    }

    private static int findIt(int[] array) {
        Arrays.sort(array);
        int count = 1;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            } else {
                if (count % 2 == 1) {
                    return array[i];
                } else {
                    count = 1;
                }
            }
        }
        return array[array.length - 1];
    }

    private static int findIt2(int[] array) {
        return Arrays.stream(array).reduce(0, (x, y) -> x ^ y);
    }

    private static int findIt3(int[] array) {
        Map<Integer, Integer> counts = new HashMap<>(array.length);
        for (int el : array) {
            if (!counts.containsKey(el)) {
                counts.put(el, 1);
            } else {
                counts.put(el, counts.get(el) + 1);
            }
        }

        for (Map.Entry<Integer, Integer> entrySet : counts.entrySet()) {
            if (entrySet.getValue() % 2 == 1) {
                return entrySet.getKey();
            }
        }
        return -1;
    }
}
