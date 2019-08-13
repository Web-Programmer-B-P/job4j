package ru.job4j.start;

import ru.job4j.input.Input;

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
}
