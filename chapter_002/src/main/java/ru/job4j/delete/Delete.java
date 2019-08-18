package ru.job4j.delete;

import ru.job4j.input.Input;
import ru.job4j.tracker.Tracker;
import ru.job4j.user.UserAction;

public class Delete implements UserAction {
    @Override
    public String key() {
        return "DELETE_ITEM";
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

    @Override
    public String info() {
        return "4. Удалить заявку по её ID";
    }
}
