package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UseSpringContext {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                                    new AnnotationConfigApplicationContext()) {
            context.register(Store.class);
            context.register(ConsoleInput.class);
            context.register(StartUI.class);
            context.refresh();
            StartUI ui = context.getBean(StartUI.class);
            String exit = "0";
            String question =
                    String.format("Введите Имя и Фамилию (для выхода - Введите "
                            + "%s)", exit);
            ui.action(question, exit);
            ui.print();
        }
    }
}
