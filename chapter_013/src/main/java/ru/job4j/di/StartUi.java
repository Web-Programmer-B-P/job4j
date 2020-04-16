package ru.job4j.di;

import org.springframework.stereotype.Component;

@Component
public class StartUi {
    private final Store store;
    private final ConsoleInput consoleInput;

    public StartUi(Store store, ConsoleInput consoleInput) {
        this.store = store;
        this.consoleInput = consoleInput;
    }

    public void add(String value) {
        store.add(value);
    }

    public void writeString() {
        store.add(consoleInput.recordString());
    }

    public void print() {
        for (String value : store.getAll()) {
            System.out.println(value);
        }
    }
}
