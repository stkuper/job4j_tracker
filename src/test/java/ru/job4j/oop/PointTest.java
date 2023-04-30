package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class PointTest {
    @Test
    public void whenA00ToB20Then2() {
        Point a = new Point(0, 0);
        Point b = new Point(2, 0);
        double expected = 2;
        double result = a.distance(b);
        assertThat((Math.abs(result - expected)) < 0.01).isTrue();
    }

    @Test
    public void whenA11ToB20Then1dot41() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 0);
        double expected = 1.41;
        double result = a.distance(b);
        assertThat((Math.abs(result - expected)) < 0.01).isTrue();
    }

    @Test
    public void whenA22ToB20Then2() {
        Point a = new Point(2, 2);
        Point b = new Point(2, 0);
        double expected = 2;
        double result = a.distance(b);
        assertThat((Math.abs(result - expected)) < 0.01).isTrue();
    }

    @Test
    public void whenA33ToB20Then3dot16() {
        Point a = new Point(3, 3);
        Point b = new Point(2, 0);
        double expected = 3.16;
        double result = a.distance(b);
        assertThat((Math.abs(result - expected)) < 0.01).isTrue();
    }
}