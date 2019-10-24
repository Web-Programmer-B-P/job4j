package ru.job4j.mail.model;

import java.util.Set;

/**
 * Class User
 *
 * @author Petr B.
 * @since 24.10.2019, 11:17
 */
public class User {
    private int id;
    private String name;
    private Set<String> email;

    public User(int i, String n, Set<String> e) {
        id = i;
        name = n;
        email = e;
    }

    public String getName() {
        return name;
    }

    public Set<String> getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name
                + '\''
                + ", email=" + email
                + '}';
    }
}
