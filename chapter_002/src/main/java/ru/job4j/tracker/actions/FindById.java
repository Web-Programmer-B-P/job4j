package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.storage.Tracker;

import java.util.function.Consumer;

public class FindById extends BaseAction {

    public FindById(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("\n------------ Поиск заявки --------------");
        String id = input.ask("Введите ID заявки: ");
        Item oneItem = tracker.findById(id);
        if (oneItem != null) {
            output.accept("\n------------ Результат поиска ---------"
                    + "\nID: "
                    + oneItem.getId()
                    + "\nИмя: "
                    + oneItem.getName()
                    + "\nОписание: "
                    + oneItem.getDesc()
                    + "\nДата создания: "
                    + oneItem.getTime()
            );
            output.accept("======================================================\n");
        } else {
            output.accept("Ошибка заявка не существует!");
        }
    }
}
