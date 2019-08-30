package ru.job4j.user;

public class User {
    private static int countOblet = 1;
    private int id;
    private String name;
    private String city;

    public User(String name, String city) {
        this.id = countOblet++;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "User{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", city='" + city + '\''
                + '}';
    }
}
