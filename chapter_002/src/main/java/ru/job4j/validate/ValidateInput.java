package ru.job4j.validate;

import ru.job4j.console.ConsoleInput;
import ru.job4j.exeption.MenuOutException;

import java.util.List;

public class ValidateInput extends ConsoleInput {
    public int ask(String question, List<Integer> range) {
        boolean invalide = true;
        int value = -1;
        do {
            try {
                return super.ask(question, range);
            } catch (MenuOutException moe) {
                System.out.println("Введите значение из диапазона!");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите повторно пункт!");
            }
        } while (invalide);
        return value;
    }
}
