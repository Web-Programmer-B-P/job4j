package ru.job4j.servlets.crud.persistent;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadSafeCounter {
    private final AtomicInteger value = new AtomicInteger(0);

    public void increment() {
        value.incrementAndGet();
    }

    public AtomicInteger getValue() {
        return value;
    }
}