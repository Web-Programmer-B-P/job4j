package ru.job4j.tracker.actions;

import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.storage.Tracker;

import java.util.List;
import java.util.function.Consumer;

public class ShowAllItems extends BaseAction {
    public ShowAllItems(int key, String name) {
        super(key, name);
    }
    @Override
    public void execute(Input input, Tracker tracker, Consumer<String> output) {
        output.accept("\n------------ Вывод всех заявок --------------");
        List<Item> all = tracker.findAll();
        if (!all.isEmpty()) {
            int index = 0;
            for (Item el : all) {
                output.accept("\tЗаявка номер: " + ((int) ++index));
                output.accept("\tID: " + el.getId());
                output.accept("\tИмя: " + el.getName());
                output.accept("\tОписание: " + el.getDesc());
                output.accept("\tДата создания: " + el.getTime());
                output.accept("==============================================");
            }
        } else {
            output.accept("\tЗаявок нет!!");
        }
    }

}
