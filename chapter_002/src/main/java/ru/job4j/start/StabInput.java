package ru.job4j.start;

import ru.job4j.exeption.MenuOutException;
import ru.job4j.input.Input;

import java.util.List;

/**
 * Class StabInput implements Input
 * Класс создан для тестов, эмитирует работу пользователя в консоле
 * @author Petr B.
 * @version 1.0
 */
public class StabInput implements Input {
    private String[] answers;
    private int position = 0;

    public StabInput(String[] anwsers) {
        this.answers = anwsers;
    }

    public String ask(String question) {
        return this.answers[this.position++];
    }

    public int ask(String question, List<Integer> range) {
        int key = Integer.parseInt(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Будте внимательны, вы вышли за предел!");
        }
    }
}
