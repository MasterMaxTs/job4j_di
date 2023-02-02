package ru.job4j.di;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ConsoleInput {

    private final Scanner scanner = new Scanner(System.in);

    public String askString(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }
}
