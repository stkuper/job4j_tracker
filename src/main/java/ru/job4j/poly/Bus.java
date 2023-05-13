package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Автобус едит");
    }

    @Override
    public void passenger(int passengers) {
        System.out.println("В автобусе " + passengers + " пассажиров");
    }

    @Override
    public double fill(double fuel) {
        return fuel * 45;
    }
}
