package ru.job4j.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " летает по воздуху");
    }

    @Override
    public void fuel() {
        System.out.println(getClass().getSimpleName() + " использует топливо керосин");
    }
}
