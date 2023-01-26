package ru.job4j.oop;

public class Plane implements Vehicle {

    @Override
    public void move() {
        System.out.println("Самолет летает по воздуху");
    }

    @Override
    public void fuel() {
        System.out.println("Самелет потребляет керосин");
    }
}
