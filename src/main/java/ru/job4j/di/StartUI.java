package ru.job4j.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StartUI {

    @Autowired
    private Store store;
    @Autowired
    private ConsoleInput input;

    public void add(String value) {
        store.add(value);
    }

    public String askString(String question) {
        return input.askString(question);
    }

    public void action(String question, String exit) {
        while (true) {
            String inputString = askString(question);
            if (inputString.equals(exit)) {
                break;
            }
            add(inputString);
        }
    }

    public void print() {
       store.getAll().forEach(System.out::println);
    }
}
