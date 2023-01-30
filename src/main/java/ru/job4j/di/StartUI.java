package ru.job4j.di;

public class StartUI {

    private final Store store;
    private final ConsoleInput input;

    public StartUI(Store store, ConsoleInput input) {
        this.store = store;
        this.input = input;
    }

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
