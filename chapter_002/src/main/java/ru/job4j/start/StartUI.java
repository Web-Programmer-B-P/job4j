package ru.job4j.start;

import ru.job4j.input.Input;
import ru.job4j.menu.MenuTracker;
import ru.job4j.tracker.Tracker;
import ru.job4j.validate.ValidateInput;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private static final int EXIT = 6;
    private final Input input;
    private final Tracker tracker;
    private int key;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        List<Integer> range = new ArrayList<>();
        menu.fillActions();
        for (int index = 0; index < menu.getActionsLentgh(); index++) {
            range.add(index);
        }
        do {
            menu.show();
            this.key = this.input.ask("Выберите пунткт: ", range);
            menu.select(this.key);
        } while (this.key != EXIT);
    }

    /**
     * Точка входа в консольное приложение
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(), new Tracker()).init();
    }
}
