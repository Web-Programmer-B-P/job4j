package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Store.class);
        context.register(ConsoleInput.class);
        context.register(StartUi.class);
        context.refresh();
        StartUi startUi = context.getBean(StartUi.class);
        startUi.writeString();
        startUi.add("Sidorov");
        startUi.writeString();
        startUi.add("Ivanov");
        startUi.print();
    }
}
