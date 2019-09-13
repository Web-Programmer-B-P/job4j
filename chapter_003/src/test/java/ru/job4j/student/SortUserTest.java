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
        Set<User> result = input.sort(
                Arrays.asList(
                        new User("Turambek", 35),
                        new User("Lenya", 21),
                        new User("Izmail", 48)
                )
        );
        List<User> excpected = List.of(
                new User("Izmail", 48),
                new User("Lenya", 21),
                new User("Turambek", 35)
                );
        assertThat(result.toString(), is(input.sort(excpected).toString()));
    }

    @Test
    public void whenSortUserByNameLeght() {
        SortUser call = new SortUser();
        List<User> input = Arrays.asList(
                new User("Сергей", 25), new User("Иван", 30),
                new User("Сергей", 20), new User("Иван", 25)
                );
        List<User> result = call.sortNameLeght(input);
        List<User> excpected = List.of(
                new User("Иван", 30),
                new User("Иван", 25),
                new User("Сергей", 25),
                new User("Сергей", 20)
        );
        assertThat(result.toString(), is(excpected.toString()));
    }

    @Test
    public void whenSortByBothFieldsOfUser() {
        SortUser call = new SortUser();
        List<User> input = Arrays.asList(
                new User("Сергей", 25), new User("Иван", 30),
                new User("Сергей", 20), new User("Иван", 25)
        );
        List<User> result = call.sortByAllFields(input);
        List<User> excpected = List.of(
                new User("Иван", 25),
                new User("Иван", 30),
                new User("Сергей", 20),
                new User("Сергей", 25)
        );
        assertThat(result.toString(), is(excpected.toString()));
    }
}
