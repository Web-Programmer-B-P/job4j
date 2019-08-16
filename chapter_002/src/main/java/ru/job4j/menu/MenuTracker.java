package ru.job4j.menu;

import ru.job4j.add.AddItem;
import ru.job4j.delete.Delete;
import ru.job4j.exit.ExitProgramm;
import ru.job4j.find.id.FindById;
import ru.job4j.find.name.FindByName;
import ru.job4j.input.Input;
import ru.job4j.show.ShowAllItems;
import ru.job4j.tracker.Tracker;
import ru.job4j.update.UpdateItem;
import ru.job4j.user.action.UserAction;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private final Input input;
    private final Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();


    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }


    public int getActionsLentgh() {
        return this.actions.size();
    }


    /**
     * Метод заполнения списка действиями.
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowAllItems());
        this.actions.add(new FindById());
        this.actions.add(new FindByName());
        this.actions.add(new Delete());
        this.actions.add(new UpdateItem());
        this.actions.add(new ExitProgramm());
    }


    /**
     * Метод выбора действия из списка с actions по ключу выполняет действие.
     * @param key
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод отрисовки меню
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
}
