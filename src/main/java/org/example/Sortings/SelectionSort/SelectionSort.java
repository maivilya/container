package org.example.Sortings.SelectionSort;

public class SelectionSort {

    /**
     * Главный метод сортировки выбором
     * @param array Неотсортированный массив
     */
    public static void sort(int[] array) {
        for (int step = 0; step < array.length; step++) {
            int index = min(array, step, array.length);

            int temp = array[step];
            array[step] = array[index];
            array[index] = temp;
        }
    }

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
