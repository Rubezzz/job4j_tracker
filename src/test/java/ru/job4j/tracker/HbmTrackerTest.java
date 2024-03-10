package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class HbmTrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test1");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenFindByIdThenTrackerReturnItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test");
            tracker.add(item);
            Item result = tracker.findById(item.getId());
            assertThat(item).isEqualTo(result);
        }
    }

    @Test
    public void whenFindByNameThenTrackerReturnItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test");
            tracker.add(item);
            List<Item> result = tracker.findByName(item.getName());
            assertThat(result).contains(item);
        }
    }

    @Test
    public void whenFindAllThenTrackerReturnAllItems() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item1 = new Item();
            item1.setName("test1");
            Item item2 = new Item();
            item2.setName("test2");
            tracker.add(item1);
            tracker.add(item2);
            List<Item> result = tracker.findAll();
            assertThat(result).contains(item1, item2);
        }
    }

    @Test
    public void whenReplaceItemThenTrackerHasReplacedItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test");
            Item replaceItem = tracker.add(item);
            replaceItem.setName("replaced");
            tracker.replace(replaceItem.getId(), replaceItem);
            Item result = tracker.findById(replaceItem.getId());
            assertThat(result.getName()).isEqualTo(item.getName());
        }
    }

    @Test
    public void whenDeleteItemThenTrackerDoesntHaveItem() throws Exception {
        try (var tracker = new HbmTracker()) {
            Item item = new Item();
            item.setName("test");
            tracker.add(item);
            tracker.delete(item.getId());
            Item result = tracker.findById(item.getId());
            assertThat(result).isNull();
        }
    }
}