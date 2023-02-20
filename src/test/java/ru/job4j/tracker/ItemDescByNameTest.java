package ru.job4j.tracker;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

class ItemDescByNameTest {

    @Test
    void whenSort() {
        List<Item> items = Arrays.asList(
                new Item("Start"),
                new Item("Cancel"),
                new Item("Apply"),
                new Item("Break")
        );
        items.sort(new ItemDescByName());
        List<Item> expected = Arrays.asList(
                new Item("Start"),
                new Item("Cancel"),
                new Item("Break"),
                new Item("Apply")
        );
        assertThat(items).isEqualTo(expected);
    }
}