package ru.job4j.oop;

public class Calculator {
    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int y) {
        return x * y;
    }

    public int divide(int y) {
        return y / x;
    }

    public int sumAllOperation(int y) {
        return sum(y) + minus(y) + multiply(y) + divide(y);
    }

    public static void main(String[] args) {
        int resultSum = sum(5);
        System.out.println("Сумма = " + resultSum);
        int resultSubtract = minus(5);
        System.out.println("Разница = " + resultSubtract);
        Calculator calculator = new Calculator();
        int resultMultiply = calculator.multiply(5);
        System.out.println("Умножение = " + resultMultiply);
        int resultDivide = calculator.divide(5);
        System.out.println("Деление = " + resultDivide);
        int resultSumAll = calculator.sumAllOperation(5);
        System.out.println("Сумма всех операций = " + resultSumAll);
    }
}
