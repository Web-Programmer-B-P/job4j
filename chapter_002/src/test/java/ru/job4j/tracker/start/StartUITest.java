package ru.job4j.tracker.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.tracker.model.Item;
import ru.job4j.tracker.StartUI;
import ru.job4j.tracker.storage.Tracker;
import ru.job4j.tracker.input.StabInput;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class StartUITest {
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);
        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };

    private static final String  MENU =
              "0. Добавить новую заявку\n"
            + "1. Показать все заявки\n"
            + "2. Найти заявку по ID\n"
            + "3. Найти заявку по её имени\n"
            + "4. Обновить заявку по её ID\n"
            + "5. Удалить заявку по ее ID\n"
            + "6. Выход из программы";



    @Test
    public void whenAddItem() {
        Tracker item = new Tracker();
        List<String> input = Arrays.asList("0", "Имя", "Описание", "6");
        new StartUI(new StabInput(input), item, this.output).init();
        assertThat(item.findAll().iterator().next().getName(), is("Имя"));
    }

    @Test
    public void whenUpdateItem() {
        Tracker track = new Tracker();
        Item in = new Item("Имя", "Описание");
        Item check = track.add(in);
        new StartUI(new StabInput(Arrays.asList("4", check.getId(), "Новое имя", "Новое описание", "6")), track, this.output).init();
        assertThat(track.findAll().iterator().next().getName(), is("Новое имя"));
    }

    @Test
    public void whenFindItemByName() {
        Tracker track = new Tracker();
        List<String> search = Arrays.asList("0", "Имя", "Описание1", "0", "Имя", "Описание2", "0", "Одна другая", "Описание3",
                           "0", "Имя", "Описание4", "3", "Имя", "6");
        new StartUI(new StabInput(search), track, this.output).init();
        assertThat(track.findByName("Имя").size(), is(3));
    }

    @Test
    public void whenFindItemById() {
        Tracker track = new Tracker();
        Item newItem = track.add(new Item("Новая", "Заявка"));
        List<String> search = Arrays.asList("2", newItem.getId(), "6");
        new StartUI(new StabInput(search), track, this.output).init();
        String result = track.findById(newItem.getId()).getName();
        assertThat(result, is("Новая"));
    }

    @Test
    public void whenDeleteItemById() {
        Tracker track = new Tracker();
        Item newItem = track.add(new Item("Новая", "Заявка"));
        List<String> search = Arrays.asList("5", newItem.getId(), "6");
        new StartUI(new StabInput(search), track, this.output).init();
        boolean result = track.findById(newItem.getId()) == null;
        assertThat(result, is(true));
    }

    @Test
    public void testOutPutAllItems() {
        Tracker tracker = new Tracker();
        Item third = new Item("12", "Третья", "Проверочная2", 123434L);
        Item first  = new Item("11", "Первая", "Проверочная1", 1234L);
        tracker.add(third);
        tracker.add(first);
        List<String> search = Arrays.asList("1", "6");
        new StartUI(new StabInput(search), tracker, output).init();
        String time1 = tracker.findById("12").getTime();
        String time2 = tracker.findById("11").getTime();
        assertThat(
                this.output.toString(),
                is(
                        new StringBuffer()
                                .append(MENU + "\n")
                                .append("\n------------ Вывод всех заявок --------------")
                                .append("\n\tЗаявка номер: 1\n\tID: 12")
                                .append("\n\tИмя: Третья\n\tОписание: Проверочная2")
                                .append("\n\tДата создания: " + time1)
                                .append("\n==============================================")
                                .append("\n\tЗаявка номер: 2\n\tID: 11")
                                .append("\n\tИмя: Первая\n\tОписание: Проверочная1")
                                .append("\n\tДата создания: " + time2)
                                .append("\n==============================================\n")
                                .append(MENU)
                                .append(System.lineSeparator()).toString()
                )
        );
    }

    @Test
    public void testOutPutFindById() {
        Tracker tracker = new Tracker();
        Item third = new Item("15", "Третья", "Проверочная2", 123434L);
        Item first  = new Item("10", "Первая", "Проверочная1", 1234L);
        tracker.add(third);
        tracker.add(first);
        List<String> search = Arrays.asList("2", "10", "6");
        new StartUI(new StabInput(search), tracker, this.output).init();
        String time = tracker.findById("10").getTime();
        assertThat(
                this.output.toString(),
                is(
                        new StringBuffer()
                                .append(MENU + "\n")
                                .append("\n------------ Поиск заявки --------------\n")
                                .append("\n------------ Результат поиска ---------\nID: 10")
                                .append("\nИмя: Первая\nОписание: Проверочная1")
                                .append("\nДата создания: " + time)
                                .append("\n======================================================\n\n")
                                .append(MENU)
                                .append(System.lineSeparator()).toString()
                )
        );
    }

    @Test
    public void testOutPutFindByName() {
        Tracker tracker = new Tracker();
        Item first = new Item("15", "Первая", "first", 123434L);
        Item second  = new Item("10", "Первая", "second", 1234L);
        Item third  = new Item("12", "Левая", "third", 1234L);
        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<String> search = Arrays.asList("3", "Первая", "6");
        new StartUI(new StabInput(search), tracker, this.output).init();
        String time1 = tracker.findById("15").getTime();
        String time2 = tracker.findById("10").getTime();
        assertThat(
                this.output.toString(),
                is(
                        new StringBuffer()
                                .append(MENU + "\n")
                                .append("\n------------ Поиск всех заявок по названию --------------\n")
                                .append("\n------------ Результат поиска --------------\n")
                                .append("\tЗаявка номер: 1\n\tID: 15")
                                .append("\n\tИмя: Первая\n\tОписание: first")
                                .append("\n\tДата создания: " + time1)
                                .append("\n==============================================\n")
                                .append("\tЗаявка номер: 2\n\tID: 10")
                                .append("\n\tИмя: Первая\n\tОписание: second")
                                .append("\n\tДата создания: " + time2)
                                .append("\n==============================================\n")
                                .append(MENU)
                                .append(System.lineSeparator()).toString()
                )
        );
    }

    @Test
    public void testOutPutUpdateItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("15", "Первая", "Описание", 123434L);
        tracker.add(first);
        List<String> search = Arrays.asList("4", "15", "Updating", "Second", "6");
        new StartUI(new StabInput(search), tracker, this.output).init();
        String date = tracker.findById("15").getTime();
        assertThat(
                this.output.toString(),
                is(
                        new StringBuffer()
                                .append(MENU + "\n")
                                .append("\n------------ Обновление заявки --------------\n")
                                .append("\n---------- Результат обновления ----------------\n")
                                .append("\nID: 15")
                                .append("\nИмя: Updating")
                                .append("\nОписание: Second")
                                .append("\nДата: " + date + "\n")
                                .append(MENU)
                                .append(System.lineSeparator()).toString()
                )
        );
    }

    @Test
    public void testOutPutDeleteItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("15", "Первая", "Описание", 123434L);
        tracker.add(first);
        List<String> search = Arrays.asList("5", "15", "6");
        new StartUI(new StabInput(search), tracker, this.output).init();
        assertThat(
                this.output.toString(),
                is(
                        new StringBuffer()
                                .append(MENU + "\n")
                                .append("\n------------ Удаление заявки --------------\n")
                                .append("Ваша заявка удалена!\n")
                                .append(MENU)
                                .append(System.lineSeparator()).toString()
                )
        );
    }

    @Test
    public void testOutPutAddItem() {
        Tracker tracker = new Tracker();
        List<String> search = Arrays.asList("0", "Add Item", "This`s a new item!", "6");
        new StartUI(new StabInput(search), tracker, this.output).init();
        assertThat(
                this.output.toString(),
                is(
                        new StringBuffer()
                                .append(MENU + "\n")
                                .append("\n------------ Добавление новой заявки --------------\n")
                                .append("Новая заявка с getId : " + tracker.findAll().iterator().next().getId() + "\n")
                                .append(MENU)
                                .append(System.lineSeparator()).toString()
                )
        );
    }
}