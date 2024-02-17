package org.example.Sortings.InsertionSort;

public class InsertionSort {

    /**
     * Метод сортировки вставками
     * @param array неотсортированный массив
     */
    public static void sort(int[] array) {
        final int length = array.length;
        for (int i = 1; i < length; i++) {
            int current = array[i];
            int j = i;
            while(j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
    }
}
