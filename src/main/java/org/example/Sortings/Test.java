package org.example.Sortings;

import org.example.Sortings.CreateArray.CreateArray;
import org.example.Sortings.MergeSort.MergeSort;
import org.example.Sortings.HeapSort.HeapSort;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        testMergeSort();
        testHeapSort();

    }

    private static void testMergeSort() {
        int[] array = CreateArray.create(12, -100, 100);
        System.out.println(Arrays.toString(array));

        int[] sortedArray = MergeSort.sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static void testHeapSort() {
        int[] array = CreateArray.create(12, -100, 100);
        System.out.println(Arrays.toString(array));
        HeapSort.sort(array);
        System.out.println(Arrays.toString(array));
    }
}