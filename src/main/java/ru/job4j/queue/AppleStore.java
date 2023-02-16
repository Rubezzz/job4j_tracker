package ru.job4j.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AppleStore {

    private final Queue<Customer> queue;
    private final int count;

    public AppleStore(Queue<Customer> queue, int count) {
        this.queue = queue;
        this.count = count;
    }

    public String getLastHappyCustomer() {
        String name = "";
        for (int i = 1; i <= count; i++) {
            if (i == count) {
                name = queue.poll().name();
            }
            queue.poll();
        }
        return name;
    }

    public String getFirstUpsetCustomer() {
        String name = "";
        for (int i = 1; i <= count + 1; i++) {
            if (i == count + 1) {
                name = queue.poll().name();
            }
            queue.poll();
        }
        return name;
    }
}
