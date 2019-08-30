package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.storage.Tracker;

import java.util.List;

public class FindByName extends BaseAction {

    public FindByName(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("\n------------ Поиск всех заявок по названию --------------");
        String name = input.ask("Введите название заявки: ");
        List<Item> allItemsByName = tracker.findByName(name);
        if (!allItemsByName.isEmpty()) {
            System.out.println("\n------------ Результат поиска --------------");
            int index = 0;
            for (Item el : allItemsByName) {
                System.out.println("\tЗаявка номер: " + ((int) ++index));
                System.out.println("\tID: " + el.getId());
                System.out.println("\tИмя: " + el.getName());
                System.out.println("\tОписание: " + el.getDesc());
                System.out.println("\tДата создания: " + el.getTime());
                System.out.println("==============================================");
            }
        } else {
            System.out.println("Заявка с таким именем не найдена! Проверте имя еще раз!");
        }
    }
}
