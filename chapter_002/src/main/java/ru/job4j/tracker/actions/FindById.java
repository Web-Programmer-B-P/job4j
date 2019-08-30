package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.storage.Tracker;

public class FindById extends BaseAction {

    public FindById(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("\n------------ Поиск заявки --------------");
        String id = input.ask("Введите ID заявки: ");
        Item oneItem = tracker.findById(id);
        if (oneItem != null) {
            System.out.println("\n------------ Результат поиска ---------"
                    + "\nID: "
                    + oneItem.getId()
                    + "\nИмя: "
                    + oneItem.getName()
                    + "\nОписание: "
                    + oneItem.getDesc()
                    + "\nДата создания: "
                    + oneItem.getTime()
            );
            System.out.println("======================================================\n");
        } else {
            System.out.println("Ошибка заявка не существует!");
        }
    }
}
