package ru.job4j.tourists.model;

import java.util.Comparator;
import java.util.Objects;

/**
 * Class Adress
 *
 * @author Petr B.
 * @since 09.09.2019, 14:10
 */
public class Address implements Comparator<Address> {
    private String city;
    private String street;
    private int home;
    private int apartment;

    public Address(String city, String street, int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }


    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    @Override
    public int compare(Address o1, Address o2) {
        return o1.getCity().compareTo(o2.getCity());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }

    @Override
    public String toString() {
        return "Address{"
                + "city='" + city
                + '\''
                + ", street='" + street
                + '\''
                + ", home=" + home
                + ", apartment=" + apartment
                + '}';
    }
}
