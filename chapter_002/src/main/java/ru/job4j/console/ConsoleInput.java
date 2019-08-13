package ru.job4j.console;

import ru.job4j.input.Input;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private Scanner in = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return this.in.nextLine();
    }
}
