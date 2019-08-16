package ru.job4j.find.id;

import ru.job4j.input.Input;
import ru.job4j.item.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.user.action.UserAction;

public class FindById implements UserAction {
    @Override
    public String key() {
        return "FIND_ITEM_BY_ID";
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

    @Override
    public String info() {
        return "2. Найти заявку по ID";
    }
}
