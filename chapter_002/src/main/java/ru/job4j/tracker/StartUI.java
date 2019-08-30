package ru.job4j.tracker;

import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.menu.MenuTracker;
import ru.job4j.tracker.storage.Tracker;
import ru.job4j.tracker.input.ValidateInput;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private boolean exit = true;
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
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker()).init();
    }
}
