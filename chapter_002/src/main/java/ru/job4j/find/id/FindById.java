package ru.job4j.find.id;

import ru.job4j.base.BaseAction;
import ru.job4j.input.Input;
import ru.job4j.item.Item;
import ru.job4j.tracker.Tracker;

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
