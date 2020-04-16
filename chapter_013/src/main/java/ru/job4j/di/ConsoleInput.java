package ru.job4j.di;

import java.util.Scanner;

public class ConsoleInput {
    public ConsoleInput() {
    }

    public String recordString() {
        String line;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Введите строку: ");
            line = scanner.nextLine();
        } while (line.isEmpty());
        return line;
    }
}
