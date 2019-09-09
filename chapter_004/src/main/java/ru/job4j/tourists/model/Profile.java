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


    public String getCity() {
        return this.address.getCity();
    }

    public String getStreet() {
        return this.address.getStreet();
    }

    public int getHome() {
        return this.address.getHome();
    }

    public int getApartament() {
        return this.address.getApartment();
    }

    public Address converTo() {
        return new Address(this.getCity(), this.getStreet(), this.getHome(), this.getApartament());
    }
}
