package ru.job4j.oop;

import static java.lang.Math.*;

public class Point {
    private int x;
    private int y;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point pointThat) {
        return sqrt(pow(this.x - pointThat.x, 2) + pow(this.y - pointThat.y, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double dist = a.distance(b);
        System.out.println(dist);
    }

}
