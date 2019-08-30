package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.storage.Tracker;

import java.util.List;

public class ShowAllItems extends BaseAction {
    public ShowAllItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("\n------------ Вывод всех заявок --------------");
        List<Item> all = tracker.findAll();
        if (!all.isEmpty()) {
            int index = 0;
            for (Item el : all) {
                System.out.println("\tЗаявка номер: " + ((int) ++index));
                System.out.println("\tID: " + el.getId());
                System.out.println("\tИмя: " + el.getName());
                System.out.println("\tОписание: " + el.getDesc());
                System.out.println("\tДата создания: " + el.getTime());
                System.out.println("==============================================");
            }
        } else {
            System.out.println("\tЗаявок нет!!");
        }
    }

}
