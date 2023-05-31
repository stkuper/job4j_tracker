package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {
    @Test
    public void whenItemAscByNameTest() {
        List<Item> items = Arrays.asList(
                new Item("First"),
                new Item("Second"),
                new Item("Third"),
                new Item("Fourth"),
                new Item("Fifth")
        );
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Fifth"),
                new Item("First"),
                new Item("Fourth"),
                new Item("Second"),
                new Item("Third")
        );
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = Arrays.asList(
                new Item("First"),
                new Item("Second"),
                new Item("Third"),
                new Item("Fourth"),
                new Item("Fifth")
        );
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Third"),
                new Item("Second"),
                new Item("Fourth"),
                new Item("First"),
                new Item("Fifth")
        );
        assertThat(items).isEqualTo(expected);
    }
}