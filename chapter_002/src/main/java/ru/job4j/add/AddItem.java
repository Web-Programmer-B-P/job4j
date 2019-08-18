package ru.job4j.add;

import ru.job4j.base.BaseAction;
import ru.job4j.input.Input;
import ru.job4j.item.Item;
import ru.job4j.tracker.Tracker;

public class AddItem extends BaseAction {

    public AddItem(final int key, final String name) {
        super(key, name);
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
}
