package ru.job4j.sort;

import org.junit.Test;
import ru.job4j.sort.model.User;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

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
}
