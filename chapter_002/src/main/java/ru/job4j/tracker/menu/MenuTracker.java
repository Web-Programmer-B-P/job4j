package ru.job4j.tracker.menu;

import ru.job4j.tracker.actions.AddItem;
import ru.job4j.tracker.actions.Delete;
import ru.job4j.tracker.actions.ExitProgramm;
import ru.job4j.tracker.actions.FindById;
import ru.job4j.tracker.actions.FindByName;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.actions.ShowAllItems;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.storage.Tracker;
import ru.job4j.tracker.actions.UpdateItem;
import ru.job4j.tracker.actions.UserAction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {
    private final Input input;
    private final Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();
    private int position = 0;
    private final Consumer<String> output;


    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }


    public int getActionsLentgh() {
        return this.actions.size();
    }


    /**
     *Метод заполнения списка действиями.
     * @param stop дополнительный параметр для выхода из программы.
     */
    public void fillActions(StartUI stop) {
        this.actions.add(new AddItem(this.position++, "Добавить новую заявку"));
        this.actions.add(new ShowAllItems(this.position++, "Показать все заявки"));
        this.actions.add(new FindById(this.position++, "Найти заявку по ID"));
        this.actions.add(new FindByName(this.position++, "Найти заявку по её имени"));
        this.actions.add(new UpdateItem(this.position++, "Обновить заявку по её ID"));
        this.actions.add(new Delete(this.position++, "Удалить заявку по ее ID"));
        this.actions.add(new ExitProgramm(this.position++, "Выход из программы", stop));
    }


    /**
     * Метод выбора действия из списка с actions по ключу выполняет действие.
     * @param key
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker, output);
    }

    /**
     * Метод отрисовки меню
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
            }
        }
    }
}
