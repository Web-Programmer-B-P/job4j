package ru.job4j.student;

import ru.job4j.student.model.User;

import java.util.*;

/**
 * Class SortUser
 *
 * @author Petr B.
 * @since 31.08.2019
 */
public class SortUser {
    /**
     * Метод сортировки пользователей по колличеству лет.
     * @param users
     * @return
     */
    public Set<User> sort(List<User> users) {
        Set<User> sortList = new TreeSet<>();
        sortList.addAll(users);
        return sortList;
    }

    /**
     * Метод сортировки пользователей по длине имени.
     * @param users
     * @return
     */
    public List<User> sortNameLeght(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                }
        );
        return users;
    }

    /**
     * Метод сортирует по всем полям
     * @param users
     * @return
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(
                new Comparator<User>() {
                    @Override
                    public int compare(User o1, User o2) {
                        int equals = o1.getName().compareTo(o2.getName());
                        return equals == 0 ? Integer.compare(o1.getAge(), o2.getAge()) : equals;
                    }
                }
        );
        return users;
    }
}
