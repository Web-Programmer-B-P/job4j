package ru.job4j.tracker;

import ru.job4j.item.Item;

import java.util.Arrays;
import java.util.Random;
import static java.lang.String.*;
import static java.lang.System.*;

/**
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
    private final Item[] items = new Item[100];
    private final Random rand = new Random();
    private int position = 0;
    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     */
    public Item add(Item item) {
        if (item.getId() == null) {
            item.setId(this.generateId());
        }
        this.items[this.position++] = item;
        return item;
    }

    /**
     * Метод обновляет заявку в случае её существования.
     * @param id
     * @param item
     * @return true/false
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index].setId(id);
                this.items[index].setName(item.getName());
                this.items[index].setDesc(item.getDesc());
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод удаляет заявку с существующим id
     * @param id
     * @return true/false
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index].getId().equals(id)) {
                this.items[index] = null;
                position--;
                System.arraycopy(this.items, index + 1, this.items, index, this.position);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод поиска всех заявок
     * @return возвращает копию массива items без значений null
     */
    public Item[] findAll() {
        Item[] result = Arrays.copyOf(this.items, this.position);
        return result;
    }

    /**
     * Метод поска заявки по имени
     * @param key
     * @return возвращает найденые совпадения
     */
    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int count = 0;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getName().equals(key)) {
                result[count] = this.items[index];
                count++;
            }
        }
        result = Arrays.copyOf(result, count);
        return result;
    }

    /**
     * Метод поиска заявки по id
     * @param id
     * @return возращает найденый Item
     */
    public Item findById(String id) {
        Item result = null;
        for (int index = 0; index < this.position; index++) {
            if (this.items[index] != null && this.items[index].getId().equals(id)) {
                result = this.items[index];
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     * @return Уникальный ключ.
     */
    private String generateId() {
        String result = format("%d%s", currentTimeMillis(), valueOf(this.rand.nextInt()));
        return result;
    }
}