package ru.job4j.add.item;

import ru.job4j.input.Input;
import ru.job4j.item.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.user.action.UserAction;

public class AddItem implements UserAction {
    @Override
    public String key() {
        return "ADD_ITEM";
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("\n------------ Добавление новой заявки --------------");
        String name = input.ask("Введите имя заявки: ");
        String desc = input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        tracker.add(item);
        System.out.println("Новая заявка с getId : " + item.getId());
    }

    @Override
    public String info() {
        return "0. Добавить новую заявку";
    }
}
