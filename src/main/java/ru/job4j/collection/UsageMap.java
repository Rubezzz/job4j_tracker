package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {

    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("mail@mail.ru", "Ivanov Ivan");
        map.put("pokpk@gmal.com", "Petrov Petr");
        map.put("serg@mail.ru", "Hmidt Sergey");
        for (String key : map.keySet()) {
            System.out.println(key + " - " + map.get(key));
        }
    }
}
