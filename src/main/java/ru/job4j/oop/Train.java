package ru.job4j.oop;

public class Train implements Vehicle {

    @Override
    public void move() {
        System.out.println("Поезд передвигается по железным дорогам");
    }

    @Override
    public void fuel() {
        System.out.println("Поезд потребляет электроэнергию");
    }
}
