package ru.job4j.di;

import java.util.Scanner;

public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public String askString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
