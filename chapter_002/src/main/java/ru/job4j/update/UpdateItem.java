package ru.job4j.update;

import ru.job4j.input.Input;
import ru.job4j.item.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.user.UserAction;

public class UpdateItem implements UserAction {
    @Override
    public String key() {
        return "UPDATE_ITEM";
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("\n------------ Обновление заявки --------------");
        String id = input.ask("Введите ID заявки которую будем обновлять: ");
        Item check = tracker.findById(id);
        if (check != null) {
            String name = input.ask("Введите имя заявки: ");
            String desc = input.ask("Введите описание заявки: ");
            Item item = new Item(name, desc);
            boolean update = tracker.replace(id, item);
            if (update) {
                Item newItem = tracker.findById(id);
                System.out.println("\n---------- Результат обновления ----------------");
                System.out.println("\nID: " + newItem.getId()
                        + "\nИмя: " + newItem.getName()
                        + "\nОписание: " + newItem.getDesc()
                        + "\nДата: " + newItem.getTime()
                );
            } else {
                System.out.println("Ошибка не удалось обновить!");
            }
        } else {
            System.out.println("Такой заявки нет!");
        }
    }

    @Override
    public String info() {
        return "5. Обновить заявку по её ID";
    }
}
