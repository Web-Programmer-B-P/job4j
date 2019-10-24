package ru.job4j.mail;

import org.junit.Before;
import org.junit.Test;
import ru.job4j.mail.model.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

/**
 * Class MergeUsersTest
 *
 * @author Petr B.
 * @since 24.10.2019, 11:26
 */
public class MergeUsersTest {
    private List<User> users = new ArrayList<>();
    @Before
    public void setUp() {
        Set<String> emailsNikola = new HashSet<>();
        emailsNikola.add("nikola@mail.ru");
        emailsNikola.add("common@mail.com");
        emailsNikola.add("privateNikola@rambler.ru");
        emailsNikola.add("job_nikola@gmail.com");


        Set<String> emailsSergey = new HashSet<>();
        emailsSergey.add("Serega1@mail.ru");
        emailsSergey.add("Serega1job@yandex.ru");
        emailsSergey.add("common@mail.com");

        Set<String> emailsVasay = new HashSet<>();
        emailsVasay.add("vasa@mail.ru");
        emailsVasay.add("vasa_job@mail.com");
        emailsVasay.add("Vaska@rambler.ru");
        emailsVasay.add("vasechkin@gmail.com");

        Set<String> emailsNindzay = new HashSet<>();
        emailsNindzay.add("nindzay@mail.ru");
        emailsNindzay.add("vasa_job@mail.com");
        emailsNindzay.add("nindzay_kill@rambler.ru");
        emailsNindzay.add("vasechkin@gmail.com");

        users.add(new User(1, "Nikola", emailsNikola));
        users.add(new User(2, "Serega", emailsSergey));
        users.add(new User(3, "Vasay", emailsVasay));
        users.add(new User(4, "Nindzay", emailsNindzay));
    }

    @Test
    public void whenMegreUserEmails() {
        MergeUsers call = new MergeUsers();
        List<User> result = call.merge(users);
        String expected = "[User{id=1, name='Nikola', email=[nikola@mail.ru, job_nikola@gmail.com,"
                + " privateNikola@rambler.ru, common@mail.com, Serega1@mail.ru, Serega1job@yandex.ru]},"
                + " User{id=3, name='Vasay', email=[vasa@mail.ru, vasechkin@gmail.com, nindzay_kill@rambler.ru,"
                + " Vaska@rambler.ru, nindzay@mail.ru, vasa_job@mail.com]}]";
        assertThat(result.toString(), is(expected));
    }
}