package ru.job4j.tracker.ru.job4j.oop;

public class Error {

    boolean active;
    int status;
    String message;

    public Error() {
    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Error active: " + this.active);
        System.out.println("Error status: " + this.status);
        System.out.println("Error message: " + this.message + System.lineSeparator());
    }

    public static void main(String[] args) {
        Error error = new Error();
        error.printInfo();
        Error error10 = new Error(true, 10, "Memory error");
        error10.printInfo();
        Error error99 = new Error(false, 99, "Fatal error");
        error99.printInfo();
    }
}
