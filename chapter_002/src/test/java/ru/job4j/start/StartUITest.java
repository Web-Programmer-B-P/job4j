package ru.job4j.start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.item.Item;
import ru.job4j.tracker.Tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String  MENU =
              "0. Добавить новую заявку\n"
            + "1. Показать все заявки\n"
            + "2. Найти заявку по ID\n"
            + "3. Найти заявку по её имени\n"
            + "4. Обновить заявку по её ID\n"
            + "5. Удалить заявку по ее ID\n"
            + "6. Выход из программы\n";

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenAddItem() {
        Tracker item = new Tracker();
        String[] initData = {"0", "Имя", "Описание", "6"};
        new StartUI(new StabInput(initData), item).init();
        assertThat(item.findAll()[0].getName(), is("Имя"));
    }

    @Test
    public void whenUpdateItem() {
        Tracker track = new Tracker();
        Item in = new Item("Имя", "Описание");
        Item check = track.add(in);
        new StartUI(new StabInput(new String[]{"4", check.getId(), "Новое имя", "Новое описание", "6"}), track).init();
        assertThat(track.findAll()[0].getName(), is("Новое имя"));
    }

    @Test
    public void whenFindItemByName() {
        Tracker track = new Tracker();
        String[] search = {"0", "Имя", "Описание1", "0", "Имя", "Описание2", "0", "Одна другая", "Описание3",
                           "0", "Имя", "Описание4", "3", "Имя", "6"};
        new StartUI(new StabInput(search), track).init();
        assertThat(track.findByName("Имя").length, is(3));
    }

    @Test
    public void whenFindItemById() {
        Tracker track = new Tracker();
        Item newItem = track.add(new Item("Новая", "Заявка"));
        String[] search = {"2", newItem.getId(), "6"};
        new StartUI(new StabInput(search), track).init();
        String result = track.findById(newItem.getId()).getName();
        assertThat(result, is("Новая"));
    }

    @Test
    public void whenDeleteItemById() {
        Tracker track = new Tracker();
        Item newItem = track.add(new Item("Новая", "Заявка"));
        String[] search = {"5", newItem.getId(), "6"};
        new StartUI(new StabInput(search), track).init();
        boolean result = track.findById(newItem.getId()) == null;
        assertThat(result, is(true));
    }

    @Test
    public void testOutPutAllItems() {
        Tracker tracker = new Tracker();
        Item third = new Item("11", "Третья", "Проверочная2", 123434L);
        Item first  = new Item("11", "Первая", "Проверочная1", 1234L);
        tracker.add(third);
        tracker.add(first);
        String[] search = {"1", "6"};
        new StartUI(new StabInput(search), tracker).init();
        assertThat(
                this.out.toString(),
                is(
                    new StringBuffer().
                            append(this.MENU).
                            append("\n------------ Вывод всех заявок --------------").
                            append("\n\tЗаявка номер: 1\n\tID: 11").
                            append("\n\tИмя: Третья\n\tОписание: Проверочная2").
                            append("\n\tДата создания: 01 янв. 1970 03:02").
                            append("\n==============================================").
                            append("\n\tЗаявка номер: 2\n\tID: 11").
                            append("\n\tИмя: Первая\n\tОписание: Проверочная1").
                            append("\n\tДата создания: 01 янв. 1970 03:00").
                            append("\n==============================================\n").
                            append(this.MENU).toString()
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
        String[] search = {"2", "10", "6"};
        new StartUI(new StabInput(search), tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringBuffer().
                                append(this.MENU).
                                append("\n------------ Поиск заявки --------------\n").
                                append("\n------------ Результат поиска ---------\nID: 10").
                                append("\nИмя: Первая\nОписание: Проверочная1").
                                append("\nДата создания: 01 янв. 1970 03:00").
                                append("\n======================================================\n\n").
                                append(this.MENU).toString()
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
        String[] search = {"3", "Первая", "6"};
        new StartUI(new StabInput(search), tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringBuffer().
                                append(this.MENU).
                                append("\n------------ Поиск всех заявок по названию --------------\n").
                                append("\n------------ Результат поиска --------------\n").
                                append("\tЗаявка номер: 1\n\tID: 15").
                                append("\n\tИмя: Первая\n\tОписание: first").
                                append("\n\tДата создания: 01 янв. 1970 03:02").
                                append("\n==============================================\n").
                                append("\tЗаявка номер: 2\n\tID: 10").
                                append("\n\tИмя: Первая\n\tОписание: second").
                                append("\n\tДата создания: 01 янв. 1970 03:00").
                                append("\n==============================================\n").
                                append(this.MENU).toString()
                )
        );
    }

    @Test
    public void testOutPutUpdateItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("15", "Первая", "Описание", 123434L);
        tracker.add(first);
        String[] search = {"4", "15", "Updating", "Second", "6"};
        new StartUI(new StabInput(search), tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringBuffer().
                                append(this.MENU).
                                append("\n------------ Обновление заявки --------------\n").
                                append("\n---------- Результат обновления ----------------\n").
                                append("\nID: 15").
                                append("\nИмя: Updating").
                                append("\nОписание: Second").
                                append("\nДата: 01 янв. 1970 03:02\n").
                                append(this.MENU).toString()
                )
        );
    }

    @Test
    public void testOutPutDeleteItem() {
        Tracker tracker = new Tracker();
        Item first = new Item("15", "Первая", "Описание", 123434L);
        tracker.add(first);
        String[] search = {"5", "15", "6"};
        new StartUI(new StabInput(search), tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringBuffer().
                                append(this.MENU).
                                append("\n------------ Удаление заявки --------------\n").
                                append("Ваша заявка удалена!\n").
                                append(this.MENU).toString()
                )
        );
    }

    @Test
    public void testOutPutAddItem() {
        Tracker tracker = new Tracker();
        String[] search = {"0", "Add Item", "This`s a new item!", "6"};
        new StartUI(new StabInput(search), tracker).init();
        assertThat(
                this.out.toString(),
                is(
                        new StringBuffer().
                                append(this.MENU).
                                append("\n------------ Добавление новой заявки --------------\n").
                                append("Новая заявка с getId : " + tracker.findAll()[0].getId() + "\n").
                                append(this.MENU).toString()
                )
        );
    }
}