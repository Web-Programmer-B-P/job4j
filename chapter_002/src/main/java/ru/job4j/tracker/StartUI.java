package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    private static final String ADD_ITEM          = "0";
    private static final String SHOW_ALL_ITEMS    = "1";
    private static final String FIND_ITEM_BY_ID   = "2";
    private static final String FIND_ITEM_BY_NAME = "3";
    private static final String DELETE_ITEM       = "4";
    private static final String UPDATE_ITEM       = "5";
    private static final String EXIT              = "6";
    private final Input input;
    private final Tracker tracker;

    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню: ");
            switch (answer) {
                case ADD_ITEM:          this.createItem(); break;
                case SHOW_ALL_ITEMS:    this.findAllItems(); break;
                case FIND_ITEM_BY_ID:   this.findById(); break;
                case FIND_ITEM_BY_NAME: this.findByName(); break;
                case DELETE_ITEM:       this.delete(); break;
                case UPDATE_ITEM:       this.updateItem(); break;
                case EXIT:              exit = true; break;
                default:    System.out.println("+--------------------------------------------------------------+");
                            System.out.println("+Такой операции нет, доступные варианты: 0, 1, 2, 3, 4, 5, 6.  +");
                            System.out.println("+--------------------------------------------------------------+");
                    break;
            }
        }
    }

    private void createItem() {
        System.out.println("\n------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("Новая заявка с getId : " + item.getId());
    }

    private void findAllItems() {
        System.out.println("\n------------ Вывод всех заявок --------------");
        Item[] all = this.tracker.findAll();
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

    private void findById() {
        System.out.println("\n------------ Поиск заявки --------------");
        String id = this.input.ask("Введите ID заявки: ");
        Item oneItem = this.tracker.findById(id);
        if (oneItem != null) {
            System.out.println("\n------------ Результат поиска ---------"
                    + "\nID: "
                    + oneItem.getId()
                    + "\nИмя: "
                    + oneItem.getName()
                    + "\nОписание: "
                    + oneItem.getDesc()
                    + "\nДата создания: "
                    + oneItem.getTime()
            );
            System.out.println("======================================================\n");
        } else {
            System.out.println("Ошибка заявка не существует!");
        }

    }

    private void findByName() {
        System.out.println("\n------------ Поиск всез заявок по названию --------------");
        String name = this.input.ask("Введите название заявки: ");
        Item[] allItemsByName = this.tracker.findByName(name);
        System.out.println("\n------------ Результат поиска --------------");
        for (int index = 0; index < allItemsByName.length; index++) {
            System.out.println("\tЗаявка номер: " + ((int) index + 1));
            System.out.println("\tID: " + allItemsByName[index].getId());
            System.out.println("\tИмя: " + allItemsByName[index].getName());
            System.out.println("\tОписание: " + allItemsByName[index].getDesc());
            System.out.println("\tДата создания: " + allItemsByName[index].getTime());
            System.out.println("==============================================");
        }
    }

    private void delete() {
        System.out.println("\n------------ Удаление заявки --------------");
        String id = this.input.ask("Введите ID заявки которую хотите удалить: ");
        boolean deleted = this.tracker.delete(id);
        if (deleted) {
            System.out.println("Ваша заявка удалена!");
        } else {
            System.out.println("Ошибка заявка не может быть удалена!");
        }
    }

    private void updateItem() {
        System.out.println("\n------------ Обновление заявки --------------");
        String id = this.input.ask("Введите ID заявки которую будем обновлять: ");
        String name = this.input.ask("Введите имя заявки: ");
        String desc = this.input.ask("Введите описание заявки: ");
        Item item = new Item(name, desc);
        boolean update = this.tracker.replace(id, item);
        if (update) {
            Item newItem = this.tracker.findById(id);
            System.out.println("\n---------- Результат обновления ----------------");
            System.out.println("\nID: " + newItem.getId()
                    + "\nИмя: " + newItem.getName()
                    + "\nОписание: " + newItem.getDesc()
                    + "\nДата: " + newItem.getTime()
            );
        } else {
            System.out.println("Ошибка не удалось обновить!");
        }
    }

    private void showMenu() {
        System.out.println("+-----------------------------------------------------+");
        System.out.println("+                      Меню.                          +");
        System.out.println("+-----------------------------------------------------+");
        System.out.println("+       0. Чтобы добавить новую заявку нажмите        +");
        System.out.println("+       1. Показать все заявки                        +");
        System.out.println("+       2. Найти заявку по ее ID                      +");
        System.out.println("+       3. Найти все заявки по названию               +");
        System.out.println("+       4. Удалить заявку по ID                       +");
        System.out.println("+       5. Обновить заявку по ID                      +");
        System.out.println("+       6. Выйти из программы нажмите                 +");
        System.out.println("+-----------------------------------------------------+");
    }


    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}
