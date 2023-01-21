package ru.job4j.inheritance;

public class JSONReport {

    public String generate(String name, String body) {
        return "{" + System.lineSeparator()
                + "\t\"name\" : \"" + name + "\"," + System.lineSeparator()
                + "\t\"body\" : \"" + body + "\"" + System.lineSeparator()
                + "}";
    }
}
