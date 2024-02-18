package org.example.Geek.Generic;

import org.example.Geek.Generic.Calculator.Calculator;
import org.example.Geek.Generic.FruitAndBoxes.Fruits.*;
import org.example.Geek.Generic.FruitAndBoxes.Box;

public class TestGeneric {

    public static void main(String[] args) {

        testCalculator();
        testFruitsAndBoxes();

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
