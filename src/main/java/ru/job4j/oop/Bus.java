package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println("Автобус передвигается по асфальтированным дорогам");
    }

    @Override
    public void fuel() {
        System.out.println("Автобус потребляет дизельное топливо");
    }
}
