package org.example.Sortings;

import org.example.Sortings.CreateArray.CreateArray;
import org.example.Sortings.MergeSort.MergeSort;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

        testMergeSort();


    }

    private static void testMergeSort() {
        int[] array = CreateArray.create(12, -100, 100);
        System.out.println(Arrays.toString(array));

        int[] sortedArray = MergeSort.sort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
