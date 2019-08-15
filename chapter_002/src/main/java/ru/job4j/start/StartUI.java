package ru.job4j.start;

import ru.job4j.console.ConsoleInput;
import ru.job4j.input.Input;
import ru.job4j.menu.tracker.MenuTracker;
import ru.job4j.tracker.Tracker;

public class StartUI {
    private static final String ADD_ITEM          = "0";
    private static final String SHOW_ALL_ITEMS    = "1";
    private static final String FIND_ITEM_BY_ID   = "2";
    private static final String FIND_ITEM_BY_NAME = "3";
    private static final String DELETE_ITEM       = "4";
    private static final String UPDATE_ITEM       = "5";
    private static final String EXIT              = "6";
    private final Input input;
    private final Tracker tracker;
    private String anwsers;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        do {
            menu.show();
            this.anwsers = this.input.ask("Выберите пунткт: ");
            menu.select(Integer.parseInt(anwsers));
        } while (!EXIT.equals(this.anwsers));
    }

    /**
     * Точка входа в консольное приложение
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
