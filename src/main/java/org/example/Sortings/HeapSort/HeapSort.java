package org.example.Sortings.HeapSort;

public class HeapSort {

    /**
     * Разбиение дерева:
     * @param array   исходный массив
     * @param maxHeap корень массива(дерева)
     * @param length  длина массива
     */
    private static void heapify(int[] array, int maxHeap, int length) {
        int left = 2 * maxHeap + 1;
        int right = 2 * maxHeap + 2;
        int largest = maxHeap;

        if (left < length && array[left] > array[largest]) {
            largest = left;
        }
        if (right < length && array[right] > array[largest]) {
            largest = right;
        }
        if (largest != maxHeap) {
            int temp = array[maxHeap];
            array[maxHeap] = array[largest];
            array[largest] = temp;

            heapify(array, largest, length);
        }
    }
}
