package org.example.codeWars;

import java.util.ArrayList;

public class Persistence {

    public static void main(String[] args) {
        System.out.println(persistence(112190));
        System.out.println(persistence2(112190));
    }

    // 999 ->  4 (9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, 1*2 = 2)
    private static long persistence(long n) {
        if (n / 10 == 0) {
            return 0;
        }
        int persistenceCount = 0;
        ArrayList<Integer> list = new ArrayList<>();
        while (n / 10 != 0) {
            list.add((int)(n % 10));
            n /= 10;
            if (n / 10 == 0) {
                for (Integer integer : list) {
                    n = n * integer;
                }
                list.clear();
                persistenceCount++;
            }
        }
        return persistenceCount;
    }

    public static int persistence2(long n) {
        if (n / 10 == 0) {
            return 0;
        }
        int persistenceCount = 0;
        int temp = 0;
        while (n / 10 != 0) {
            temp = 1;
            while(n > 0) {
                temp *= n % 10;
                n /= 10;
            }
            n = temp;
            persistenceCount++;
        }
        return persistenceCount;
    }
}
