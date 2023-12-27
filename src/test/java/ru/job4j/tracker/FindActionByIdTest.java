package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class FindActionByIdTest {

    @Test
    public void whenItemFindByIdThenNotFound() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        tracker.add(new Item("Find item"));
        int idItem = 5;
        FindActionById findAction = new FindActionById(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(idItem);

        findAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + "Заявка с введенным id: " + idItem + " не найдена." + ln
        );
    }

    @Test
    public void whenItemFindByIdThenFound() {
        Output output = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Find item");
        tracker.add(item);
        int idItem = 1;
        FindActionById findAction = new FindActionById(output);

        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(idItem);

        findAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "=== Find item by id ===" + ln
                        + item + ln
        );
    }
}