package ru.job4j.oop;

import static java.lang.Math.*;

public class Point {
    private int x;
    private int y;
    private int z;

    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public Point(int first, int second, int third) {
        this.x = first;
        this.y = second;
        this.z = third;
    }

    public double distance(Point pointThat) {
        return sqrt(pow(this.x - pointThat.x, 2) + pow(this.y - pointThat.y, 2));
    }

    public double distance3d(Point pointThat) {
        return sqrt(pow(this.x - pointThat.x, 2) + pow(this.y - pointThat.y, 2) + pow(this.z - pointThat.z, 2));
    }

    public static void main(String[] args) {
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double dist = a.distance(b);
        System.out.println(dist);
        Point c = new Point(0, 0, 0);
        Point d = new Point(0, 3, 0);
        System.out.println(c.distance3d(d));
    }

}
