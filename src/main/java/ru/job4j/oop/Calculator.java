package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int number) {
        return number - x;
    }

    public int divide(int number) {
        return number / x;
    }

    public int sumAllOperation(int number) {
        return sum(number) + minus(number) + divide(number) + multiply(number);
    }

    public int multiply(int a) {
        return x * a;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("Sum = " + Calculator.sum(10));
        System.out.println("Minus = " + Calculator.minus(15));
        System.out.println("Divide = " + calc.divide(5));
        System.out.println("Multiply = " + calc.multiply(2));
        System.out.println("sumAllOperation = " + calc.sumAllOperation(50));
    }
}
