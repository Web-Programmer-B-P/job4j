package ru.job4j.exeption;

public class MenuOutException extends RuntimeException {
    public MenuOutException(String message) {
        super(message);
    }
}
