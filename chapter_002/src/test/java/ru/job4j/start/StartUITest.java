package ru.job4j.start;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import ru.job4j.item.Item;
import ru.job4j.tracker.Tracker;

public class StartUITest {
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
}