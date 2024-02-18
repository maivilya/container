package org.example.Geek.Generic.CompareArrays;

public class CompareArrays {

    /**
     * Метод, проверяющий равны ли массивы.
     * Возвращает true, если длина массивов равна и тип каждого элемента
     * равен типу элемента другого массива соответственно.
     * @param tArray первый массив для сравнения
     * @param eArray второй массив для сравнения
     * @return       true, если массивы равны
     * @param <T>    тип первого массива
     * @param <E>    тип второго массива
     */
    public static <T, E> boolean compare(T[] tArray, E[] eArray) {
        if (tArray.length != eArray.length) {
            return false;
        }
        for (int i = 0; i < tArray.length; i++) {
            if (!tArray[i].getClass().equals(eArray[i].getClass())) {
                return false;
            }
        }
        return true;
    }
}
