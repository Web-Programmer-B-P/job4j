package ru.job4j.di;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private final Map<String, Object> registeredObjects = new HashMap<>();

    public void registered(Class rClass) {
        Constructor[] constructors = rClass.getDeclaredConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multiple constructors : " + rClass.getCanonicalName());
        }
        Constructor constructor = constructors[0];
        List<Object> argumentsFromConstructor = new ArrayList<>();
        for (Class argument : constructor.getParameterTypes()) {
            if (!registeredObjects.containsKey(argument.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't found in context : " + argument.getCanonicalName());
            }
            argumentsFromConstructor.add(registeredObjects.get(argument.getCanonicalName()));
        }
        try {
            registeredObjects.put(rClass.getCanonicalName(), constructor.newInstance(argumentsFromConstructor.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Couldn't create an instance of : " + rClass.getCanonicalName(), e);
        }
    }

    public <T> T get(Class<T> inst) {
        return (T) registeredObjects.get(inst.getCanonicalName());
    }
}
