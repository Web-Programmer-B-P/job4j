package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.storage.Tracker;

import java.util.function.Consumer;

public class Delete extends BaseAction {
    public Delete(int key, String name) {
        super(key, name);
    }

    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("\n------------ Удаление заявки --------------");
        String id = input.ask("Введите ID заявки которую хотите удалить: ");
        boolean deleted = tracker.delete(id);
        if (deleted) {
            output.accept("Ваша заявка удалена!");
        } else {
            output.accept("Ошибка заявка не может быть удалена!");
        }
    }
}
