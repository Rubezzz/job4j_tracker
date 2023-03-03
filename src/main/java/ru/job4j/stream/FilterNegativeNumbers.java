package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, -3, 6, -1, 0);
        List<Integer> positive = numbers
                .stream()
                .filter(i -> i > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}