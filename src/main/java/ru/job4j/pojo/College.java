package ru.job4j.pojo;

import java.time.LocalDate;

public class College {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Ivan Vanovich");
        student.setGroup("IT-32");
        student.setDate(LocalDate.now());
        System.out.println("Student " + student.getName()
                           + " studying in group " + student.getGroup()
                           + " since " + student.getDate());
    }
}