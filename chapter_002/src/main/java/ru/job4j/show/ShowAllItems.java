package ru.job4j.show;

import ru.job4j.base.BaseAction;
import ru.job4j.input.Input;
import ru.job4j.item.Item;
import ru.job4j.tracker.Tracker;

public class ShowAllItems extends BaseAction {
    public ShowAllItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("\n------------ Вывод всех заявок --------------");
        Item[] all = tracker.findAll();
        if (all.length > 0) {
            for (int index = 0; index < all.length; index++) {
                System.out.println("\tЗаявка номер: " + ((int) index + 1));
                System.out.println("\tID: " + all[index].getId());
                System.out.println("\tИмя: " + all[index].getName());
                System.out.println("\tОписание: " + all[index].getDesc());
                System.out.println("\tДата создания: " + all[index].getTime());
                System.out.println("==============================================");
            }
        } else {
            System.out.println("\tЗаявок нет!!");
        }
    }

}
