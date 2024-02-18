package org.example.Geek.Generic.Calculator;

public class Calculator {

    public static <T extends Number, E extends Number> double sum(T tValue, E eValue) {
        return tValue.doubleValue() + eValue.doubleValue();
    }

    public static <T extends Number, E extends Number> double multiply(T tValue, E eValue) {
        return tValue.doubleValue() * eValue.doubleValue();
    }

    public static <T extends Number, E extends Number> double devide(T tValue, E eValue) {
        if (eValue.doubleValue() == 0) {
            throw new ArithmeticException("/ by zero");
        }
        return tValue.doubleValue() / eValue.doubleValue();
    }

    public static <T extends Number, E extends Number> double subtract(T tValue, E eValue) {
        return tValue.doubleValue() - eValue.doubleValue();
    }
}
