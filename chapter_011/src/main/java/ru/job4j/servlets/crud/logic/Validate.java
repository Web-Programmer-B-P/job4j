package ru.job4j.servlets.crud.logic;

import ru.job4j.servlets.crud.model.User;
import java.util.List;

public interface Validate {
    void add(User user);
    void update(User user);
    void delete(int id);
    List<User> findAll();
    User findById(int id);
    int getNewId();
}
