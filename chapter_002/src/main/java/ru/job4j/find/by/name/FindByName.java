package ru.job4j.find.by.name;

import ru.job4j.input.Input;
import ru.job4j.item.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.user.action.UserAction;

public class FindByName implements UserAction {
    @Override
    public String key() {
        return "FIND_ITEM_BY_NAME";
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        System.out.println("\n------------ Поиск всех заявок по названию --------------");
        String name = input.ask("Введите название заявки: ");
        Item[] allItemsByName = tracker.findByName(name);
        if (allItemsByName.length > 0) {
            System.out.println("\n------------ Результат поиска --------------");
            for (int index = 0; index < allItemsByName.length; index++) {
                System.out.println("\tЗаявка номер: " + ((int) index + 1));
                System.out.println("\tID: " + allItemsByName[index].getId());
                System.out.println("\tИмя: " + allItemsByName[index].getName());
                System.out.println("\tОписание: " + allItemsByName[index].getDesc());
                System.out.println("\tДата создания: " + allItemsByName[index].getTime());
                System.out.println("==============================================");
            }
        } else {
            System.out.println("Заявка с таким именем не найдена! Проверте имя еще раз!");
        }
    }

    @Override
    public String info() {
        return "3. Найти заявку(ки) по её имени";
    }
}
