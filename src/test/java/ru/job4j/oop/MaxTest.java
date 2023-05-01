package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MaxTest {
    @Test
    public void whenMax3To5Then5() {
        int first = 3;
        int second = 5;
        int expected = 5;
        int result = Max.max(first, second);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax1To3To5Then5() {
        int first = 1;
        int second = 3;
        int third = 5;
        int expected = 5;
        int result = Max.max(first, second, third);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenMax7To5To3To1Then7() {
        int first = 7;
        int second = 5;
        int third = 3;
        int thourth = 1;
        int expected = 7;
        int result = Max.max(first, second, third, thourth);
        assertThat(result).isEqualTo(expected);
    }
}