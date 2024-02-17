package org.example.Sortings;

public class MergeSort {

    /**
     * Слияние двух массивов в один(исходные массивы отсортированны, результирующий массив отсортирован)
     * @param src1      первый подмассив
     * @param src1Start точка старта слияния из первого подмассива
     * @param src2      второй подмассив
     * @param src2Start точка старта слияния из второго подмассива
     * @param dest      массив приемник
     * @param destStart точка старта записи в массив приемник
     * @param size      размеры подмассивов
     */
    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start,
                              int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

}
