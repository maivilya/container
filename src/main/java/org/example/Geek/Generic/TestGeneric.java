package org.example.Geek.Generic;

import org.example.Geek.Generic.Calculator.Calculator;
import org.example.Geek.Generic.CompareArrays.CompareArrays;
import org.example.Geek.Generic.FruitAndBoxes.Fruits.*;
import org.example.Geek.Generic.FruitAndBoxes.Box;

public class TestGeneric {

    public static void main(String[] args) {
        testCalculator();
        testFruitsAndBoxes();
        testCompareArrays();
    }

    private static void testCompareArrays() {
        Integer[] integers0 = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        Integer[] integers1 = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        boolean compare0 = CompareArrays.compare(integers0, integers1);
        System.out.println("compare = " + compare0);

        String[] strings0 = new String[]{"bow", "cow", "rabbit", "wolf"};
        String[] strings1 = new String[]{"cow", "rabbit", "wolf"};
        boolean compare1 = CompareArrays.compare(strings0, strings1);
        System.out.println("compare1 = " + compare1);

        Double[] doubles = new Double[]{2.4, 17.7, 192.3, 15.0};
        Object[] objects = new Object[]{1, "car", 26.1, 'T'};
        boolean compare2 = CompareArrays.compare(doubles, objects);
        System.out.println("compare2 = " + compare2);
    }

    private static void testFruitsAndBoxes() {
        Box<Fruit> boxFruit = new Box<>();
        Box<Apple> boxApple = new Box<>();
        Box<Orange> boxOrange = new Box<>();


        for (int i = 0; i < 10; i++) {
            boxApple.addFruit(new Apple());
        }

        for (int i = 0; i < 10; i++) {
            boxOrange.addFruit(new Orange());
        }

        System.out.printf("Apple box: %d fruits; %.1f kg\n", boxApple.getSize(), boxApple.getWeight());
        System.out.printf("Orange box: %d fruits; %.1f kg\n", boxOrange.getSize(), boxOrange.getWeight());
        System.out.printf("Fruit box: %d fruits; %.1f kg\n", boxFruit.getSize(), boxFruit.getWeight());

        System.out.println(boxApple.compare(boxOrange));

        boxApple.pourTo(boxFruit);
        boxOrange.pourTo(boxFruit);

        System.out.printf("\nApple box: %d fruits; %.1f kg\n", boxApple.getSize(), boxApple.getWeight());
        System.out.printf("Orange box: %d fruits; %.1f kg\n", boxOrange.getSize(), boxOrange.getWeight());
        System.out.printf("Fruit box: %d fruits; %.1f kg\n", boxFruit.getSize(), boxFruit.getWeight());
    }

    private static void testCalculator() {
        double sum = Calculator.sum(3.2, 4.3);
        System.out.println("sum = " + sum);
        double multiply = Calculator.multiply(17, 2);
        System.out.println("multiply = " + multiply);
    }
}
