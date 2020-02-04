package ru.job4j.servlets.crud.persistent;

import ru.job4j.servlets.crud.model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryStore implements Store {
    private final Map<Integer, User> storage = new ConcurrentHashMap<>();
    private final ThreadSafeCounter id = new ThreadSafeCounter();

    private MemoryStore() {
    }

    public static MemoryStore getInstance() {
        return InitInstance.INSTANCE;
    }

    private static final class InitInstance {
        private static final MemoryStore INSTANCE = new MemoryStore();
    }

    @Override
    public void add(User user) {
        storage.put(user.getId(), user);
    }

    @Override
    public void update(User user) {
        storage.replace(user.getId(), user);
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public User findById(int id) {
        User res = null;
        if (storage.containsKey(id)) {
            res = storage.get(id);
        }
        return res;
    }
}
