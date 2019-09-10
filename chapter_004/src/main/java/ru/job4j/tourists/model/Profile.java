package ru.job4j.tourists.model;

import java.util.Objects;

/**
 * Class Profile
 *
 * @author Petr B.
 * @since 09.09.2019, 14:10
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return this.address;
    }
}
