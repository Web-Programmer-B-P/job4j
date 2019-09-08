package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.menu.MenuTracker;
import ru.job4j.tracker.storage.Tracker;
import ru.job4j.tracker.input.ValidateInput;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class StartUI {
    private boolean exit = true;
    private final Input input;
    private final Tracker tracker;
    private int key;
    private final Consumer<String> output;

    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        List<Integer> range = new ArrayList<>();
        menu.fillActions(this);
        for (int index = 0; index < menu.getActionsLentgh(); index++) {
            range.add(index);
        }
        do {
            menu.show();
            this.key = this.input.ask("Выберите пунткт: ", range);
            menu.select(this.key);
        } while (this.exit);
    }

    public void exit() {
        this.exit = false;
    }

    /**
     * Точка входа в консольное приложение
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}
