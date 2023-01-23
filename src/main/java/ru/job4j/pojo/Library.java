package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book history = new Book("History", 205);
        Book horror = new Book("Horror", 150);
        Book cleanCode = new Book("Clean Code", 123);
        Book detective = new Book("Detective", 438);
        Book[] array = {history, horror, cleanCode, detective};
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].getName() + " - " + array[i].getCountPages() + " pages");
        }
        Book temp = array[0];
        array[0] = array[3];
        array[3] = temp;
        System.out.println(System.lineSeparator());
        for (Book book : array) {
            System.out.println(book.getName() + " - " + book.getCountPages() + " pages");
        }
        System.out.println(System.lineSeparator());
        for (Book book : array) {
            if ("Clean Code".equals(book.getName())) {
                System.out.println(book.getName() + " - " + book.getCountPages() + " pages");
            }
        }
    }
}
