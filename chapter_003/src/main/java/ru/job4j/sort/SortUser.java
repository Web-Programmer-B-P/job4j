package ru.job4j.sort;

import ru.job4j.sort.model.User;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * Class SortUser
 *
 * @author Petr B.
 * @since 31.08.2019
 */
public class SortUser {
    public Set<User> sort(List<User> users) {
        Set<User> sortList = new TreeSet<>();
        sortList.addAll(users);
        return sortList;
    }
}
