package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
    }

    @Override
    public void passenger(int passengers) {
    }

    @Override
    public double fill(double fuel) {
        return fuel * 45;
    }
}
