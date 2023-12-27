package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindActionByNameTest {

    @Test
    public void whenItemFindByNameThenNotFound() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Find item"));
        String nameItem = "New item name";
        FindActionByName findAction = new FindActionByName(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(nameItem);

        findAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + "Заявки с именем: " + nameItem + " не найдены." + ln
        );
    }

    @Test
    public void whenItemFindByNameThenFound() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Find item");
        tracker.add(item);
        String nameItem = "Find item";
        FindActionByName findAction = new FindActionByName(output);

        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(nameItem);

        findAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find items by name ===" + ln
                        + item + ln
        );
    }
}