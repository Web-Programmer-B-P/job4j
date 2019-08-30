package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.storage.Tracker;

public class Delete extends BaseAction {
    public Delete(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("\n------------ Удаление заявки --------------");
        String id = input.ask("Введите ID заявки которую хотите удалить: ");
        boolean deleted = tracker.delete(id);
        if (deleted) {
            System.out.println("Ваша заявка удалена!");
        } else {
            System.out.println("Ошибка заявка не может быть удалена!");
        }
    }
}
