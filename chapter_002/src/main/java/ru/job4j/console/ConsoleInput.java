package ru.job4j.console;

import ru.job4j.exeption.MenuOutException;
import ru.job4j.input.Input;

import java.util.List;
import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner in = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return this.in.nextLine();
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
