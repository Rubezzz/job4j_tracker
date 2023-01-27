package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void run() {
        System.out.println("Автобус едет");
    }

    @Override
    public void passengers(int count) {
        System.out.println("Количество пассажиров: " + count);
    }

    @Override
    public double refuel(double count) {
        double price = 48.5;
        return count * price;
    }
}
