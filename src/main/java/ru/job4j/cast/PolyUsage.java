package ru.job4j.cast;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle boing = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();
        Vehicle airbus = new Plane();
        Vehicle quickTrain = new Train();
        Vehicle cityBus = new Bus();
        Vehicle[] vehicles = new Vehicle[]{boing, train, bus, airbus, quickTrain, cityBus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.fuel();
        }
    }
}
