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
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void whenA11ToB20Then1dot41() {
        Point a = new Point(1, 1);
        Point b = new Point(2, 0);
        double expected = 1.414;
        double result = a.distance(b);
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void whenA22ToB20Then2() {
        Point a = new Point(2, 2);
        Point b = new Point(2, 0);
        double expected = 2;
        double result = a.distance(b);
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void whenA33ToB20Then3dot16() {
        Point a = new Point(3, 3);
        Point b = new Point(2, 0);
        double expected = 3.162;
        double result = a.distance(b);
        assertThat(result).isCloseTo(expected, offset(0.001));
    }

    @Test
    public void whenA012ToB432Then4dot472() {
        Point a = new Point(0, 1, 2);
        Point b = new Point(4, 3, 2);
        double result = a.distance3d(b);
        double expected = 4.472;
        assertThat(result).isCloseTo(expected, offset(0.001));
    }
}