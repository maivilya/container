package org.example.Sortings.CreateArray;

import java.util.Random;

public class CreateArray {

    private static final Random random = new Random();

    /**
     * Метод создания массива со случайными значениями(для тестов)
     * @param length длина массива
     * @param min    минимальное значение в массиве
     * @param max    максимальное значение в масисве
     * @return       массив по здаанным параметрам
     */
    public static int[] create(int length, int min, int max) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt((max - min) + 1) + min;
        }
        return array;
    }
}
