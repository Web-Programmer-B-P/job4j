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
        new StartUI(new StabInput(new String[]{"5", check.getId(), "Новое имя", "Новое описание", "6"}), track).init();
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
        String[] search = {"4", newItem.getId(), "6"};
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
                            append("+-----------------------------------------------------+").
                            append("\n+                      Меню.                          +").
                            append("\n+-----------------------------------------------------+\n").
                            append("+       0. Чтобы добавить новую заявку нажмите        +").
                            append("\n+       1. Показать все заявки                        +").
                            append("\n+       2. Найти заявку по ее ID                      +").
                            append("\n+       3. Найти все заявки по названию               +").
                            append("\n+       4. Удалить заявку по ID                       +").
                            append("\n+       5. Обновить заявку по ID                      +").
                            append("\n+       6. Выйти из программы нажмите                 +").
                            append("\n+-----------------------------------------------------+\n").
                            append("\n------------ Вывод всех заявок --------------").
                            append("\n\tЗаявка номер: 1\n\tID: 11").
                            append("\n\tИмя: Третья\n\tОписание: Проверочная2").
                            append("\n\tДата создания: 01 янв. 1970 03:02").
                            append("\n==============================================").
                            append("\n\tЗаявка номер: 2\n\tID: 11").
                            append("\n\tИмя: Первая\n\tОписание: Проверочная1").
                            append("\n\tДата создания: 01 янв. 1970 03:00").
                            append("\n==============================================").
                            append("\n+-----------------------------------------------------+").
                            append("\n+                      Меню.                          +").
                            append("\n+-----------------------------------------------------+\n").
                            append("+       0. Чтобы добавить новую заявку нажмите        +").
                            append("\n+       1. Показать все заявки                        +").
                            append("\n+       2. Найти заявку по ее ID                      +").
                            append("\n+       3. Найти все заявки по названию               +").
                            append("\n+       4. Удалить заявку по ID                       +").
                            append("\n+       5. Обновить заявку по ID                      +").
                            append("\n+       6. Выйти из программы нажмите                 +").
                            append("\n+-----------------------------------------------------+").
                            append(System.lineSeparator()).toString()
                )
        );
    }
}