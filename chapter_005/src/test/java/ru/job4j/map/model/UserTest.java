package ru.job4j.map.model;

import org.junit.Before;
import org.junit.Test;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 * Class UserTest
 *
 * @author Petr B.
 * @since 13.10.2019, 8:35
 */
public class UserTest {
    private long date = 13112019;

    @Test
    public void whenCreateTwoObjectUserAndPutToMap() {
        Map<User, String> storage = new HashMap<>();
        storage.put(new User("Alibaba", 40, date), "first");
        storage.put(new User("Alibaba", 40, date), "first");
        String expected = "{User{name='Alibaba', children=40, birthday=13112019}=first,"
                + " User{name='Alibaba', children=40, birthday=13112019}=first}";
        assertThat(storage.toString(), is(expected));
    }
}