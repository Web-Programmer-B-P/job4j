package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.storage.Tracker;

public class UpdateItem extends BaseAction {

    public UpdateItem(int key, String name) {
        super(key, name);
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
}
