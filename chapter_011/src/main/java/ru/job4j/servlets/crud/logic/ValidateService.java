package ru.job4j.servlets.crud.logic;

import ru.job4j.servlets.crud.db.DbStore;
import ru.job4j.servlets.crud.model.User;
import ru.job4j.servlets.crud.persistent.Store;
import java.util.List;

public class ValidateService implements Validate {
    private static final ValidateService INSTANCE = new ValidateService();
    private final Store logic = DbStore.getInstance();

    private ValidateService() {

    }

    public static ValidateService getInstance() {
        return INSTANCE;
    }

    @Override
    public void add(User user) {
        if (findById(user.getId()) == null) {
            logic.add(user);
        }
    }

    @Override
    public void update(User user) {
        logic.update(user);
    }

    @Override
    public void delete(int id) {
        logic.delete(id);
    }

    @Override
    public List<User> findAll() {
        return logic.findAll();
    }

    @Override
    public User findById(int id) {
        return logic.findById(id);
    }
}
