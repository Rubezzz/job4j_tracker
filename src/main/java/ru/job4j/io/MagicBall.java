package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Я великий Оракул. Что ты хочешь узнать? ");
        String question = scanner.nextLine();
        int answer = new Random().nextInt(3);
        String out = switch (answer) {
          case 0 -> "Да";
          case 1 -> "Нет";
          default -> "Может быть";
        };
        System.out.println(question.concat(" Ответ: ").concat(out));
    }
}
