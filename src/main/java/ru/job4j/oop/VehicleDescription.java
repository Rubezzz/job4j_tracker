package ru.job4j.oop;

public class VehicleDescription {

    public static void main(String[] args) {
        Vehicle bus = new Bus();
        Vehicle train = new Train();
        Vehicle plain = new Plane();
        Vehicle[] vehicles = {bus, train, plain};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.fuel();
        }
    }
}
