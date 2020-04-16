package ru.job4j.di;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.registered(Store.class);
        context.registered(ConsoleInput.class);
        context.registered(StartUi.class);
        StartUi startUi = context.get(StartUi.class);
        startUi.writeString();
        startUi.add("Sidorov");
        startUi.writeString();
        startUi.add("Ivanov");
        startUi.print();
    }
}
