package ru.job4j.tourists;

import org.junit.Test;
import ru.job4j.tourists.model.Address;
import ru.job4j.tourists.model.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class ProfilesTest
 *
 * @author Petr B.
 * @since 09.09.2019, 16:43
 */
public class ProfilesTest {
    @Test
    public void whenConvertProfileToListAddress() {
        Profile one = new Profile(new Address("Kazan", "Lomonosova", 1, 23));
        Profile two = new Profile(new Address("Vladivostok", "Mamontova", 34, 88));
        Profile three = new Profile(new Address("Sverdlovsk", "Pushkina", 10, 43));
        Profile four = new Profile(new Address("Piter", "Piragova", 90, 276));
        List<Profile> tourists = Arrays.asList(one, two, three, four);
        Profiles input = new Profiles();
        List<Address> result = input.collect(tourists);
        String expected = "[Address{city='Kazan', street='Lomonosova', home=1, apartment=23},"
               + " Address{city='Vladivostok', street='Mamontova', home=34, apartment=88},"
               + " Address{city='Sverdlovsk', street='Pushkina', home=10, apartment=43},"
               + " Address{city='Piter', street='Piragova', home=90, apartment=276}]";
        assertThat(result.toString(), is(expected));
    }

    @Test
    public void whenSortedAndDinstinct() {
        Profile one = new Profile(new Address("Kazan", "Lomonosova", 1, 23));
        Profile two = new Profile(new Address("Kazan", "Lomonosova", 1, 23));
        Profile three = new Profile(new Address("Sverdlovsk", "Pushkina", 10, 43));
        Profile four = new Profile(new Address("Piter", "Piragova", 90, 276));
        List<Profile> tourists = Arrays.asList(one, two, three, four);
        Profiles input = new Profiles();
        List<Address> result = input.collect(tourists);
        String expected = "[Address{city='Kazan', street='Lomonosova', home=1, apartment=23},"
                + " Address{city='Sverdlovsk', street='Pushkina', home=10, apartment=43},"
                + " Address{city='Piter', street='Piragova', home=90, apartment=276}]";
        assertThat(result.toString(), is(expected));
    }
}