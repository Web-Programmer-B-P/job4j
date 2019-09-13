package ru.job4j.student;

import org.junit.Test;
import ru.job4j.student.model.User;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SortUserTest {
    @Test
    public void whenSortAndReturnListUserHowTreeSet() {
        SortUser input = new SortUser();
        Set<User> result = input.sort(Arrays.asList(new User("Izmail", 48),
                new User("Turambek", 35), new User("Lenya", 21)));
        String excpected = "[User{name='Lenya', age=21}, User{name='Turambek', age=35}, User{name='Izmail', age=48}]";
        assertThat(result.toString(), is(excpected));
    }

    @Test
    public void whenSortUserByNameLeght() {
        SortUser call = new SortUser();
        List<User> input = Arrays.asList(new User("Сергей", 25), new User("Иван", 30),
                new User("Сергей", 20), new User("Иван", 25));
        List<User> result = call.sortNameLeght(input);
        String excpected = "[User{name='Иван', age=30}, User{name='Иван', age=25}, User{name='Сергей', age=25}, "
                + "User{name='Сергей', age=20}]";
        assertThat(result.toString(), is(excpected));
    }

    @Test
    public void whenSortByBothFieldsOfUser() {
        SortUser call = new SortUser();
        List<User> input = Arrays.asList(new User("Сергей", 25), new User("Иван", 30),
                new User("Сергей", 20), new User("Иван", 25));
        List<User> result = call.sortByAllFields(input);
        String excpected = "[User{name='Иван', age=25}, User{name='Иван', age=30}, User{name='Сергей', age=20}, "
                + "User{name='Сергей', age=25}]";
        assertThat(result.toString(), is(excpected));
    }
}
