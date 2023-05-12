package ru.job4j.tracker.oop;

import ru.job4j.tracker.oop.Freshman;
import ru.job4j.tracker.oop.Student;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student student = freshman;
        Object obj = freshman;
    }
}
