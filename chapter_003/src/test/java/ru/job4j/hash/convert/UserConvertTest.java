package ru.job4j.hash.convert;

import org.junit.Test;
import ru.job4j.hash.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserConvertTest {
    @Test
    public void whenGetHashMapWithKeyUserId() {
        User person1 = new User("Valiko", "Gruziya");
        User person2 = new User("Igor", "Vladivostok");
        User person3 = new User("Li", "China");
        List<User> input = new ArrayList<>(Arrays.asList(person1, person2, person3));
        UserConvert init = new UserConvert();
        HashMap<Integer, User> result = init.process(input);
        String excpected = "User{id=3, name='Li', city='China'}";
        assertThat(result.get(3).toString(), is(excpected));
    }
}
