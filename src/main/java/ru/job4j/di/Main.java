package ru.job4j.di;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.reg(Store.class);
        context.reg(ConsoleInput.class);
        context.reg(StartUI.class);
        StartUI ui = context.get(StartUI.class);
        String exit = "0";
        String question =
                String.format("Введите Имя и Фамилию (для выхода - Введите "
                        + "%s)", exit);
        ui.action(question, exit);
        ui.print();
    }
}

