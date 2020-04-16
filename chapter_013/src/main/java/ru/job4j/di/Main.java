package ru.job4j.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("ru.job4j.di");
        context.refresh();
        StartUi startUi = context.getBean(StartUi.class);
        startUi.writeString();
        startUi.add("Sidorov");
        startUi.writeString();
        startUi.add("Ivanov");
        startUi.print();
    }
}
