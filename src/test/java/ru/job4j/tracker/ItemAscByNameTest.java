package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.assertj.core.api.Assertions.assertThat;

class ItemAscByNameTest {

    @Test
    void whenSort() {
        List<Item> items = Arrays.asList(
                new Item("Start"),
                new Item("Cancel"),
                new Item("Apply"),
                new Item("Break")
        );
        items.sort(new ItemAscByName());
        List<Item> expected = Arrays.asList(
                new Item("Apply"),
                new Item("Break"),
                new Item("Cancel"),
                new Item("Start")
        );
        assertThat(items).isEqualTo(expected);
    }
}