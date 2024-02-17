package org.example.Sortings.SelectionSort;

public class SelectionSort {

    /**
     * Поиск индекса минимального значения массива
     * @param array Массив
     * @param start Индекс, с которого начинать искать минимальный элемент
     * @return      Индекс минимального элемента
     */
    private static int min(int[] array, int start, int end) {
        int minIndex = start;
        int minValue = array[start];
        for (int i = start + 1; i < end; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
