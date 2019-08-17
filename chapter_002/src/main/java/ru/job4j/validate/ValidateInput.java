package ru.job4j.validate;

import ru.job4j.console.ConsoleInput;
import ru.job4j.exeption.MenuOutException;
import ru.job4j.input.Input;

import java.util.List;

public class ValidateInput implements Input {
    private final Input input;

    public ValidateInput(final Input input) {
        this.input = input;
    }

    public String ask(String question) {
        return this.input.ask(question);
    }

    public int ask(String question, List<Integer> range) {
        boolean invalide = true;
        int value = -1;
        do {
            try {
                return this.input.ask(question, range);
            } catch (MenuOutException moe) {
                System.out.println("Введите значение из диапазона!");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите повторно пункт!");
            }
        } while (invalide);
        return value;
    }
}
