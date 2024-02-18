package org.example.Geek.Generic;

import org.example.Geek.Generic.Calculator.Calculator;

public class TestGeneric {

    public static void main(String[] args) {
        testCalculator();
    }

    private static void testCalculator() {
        double sum = Calculator.sum(3.2, 4.3);
        System.out.println("sum = " + sum);
        double multiply = Calculator.multiply(17, 2);
        System.out.println("multiply = " + multiply);
    }
}
