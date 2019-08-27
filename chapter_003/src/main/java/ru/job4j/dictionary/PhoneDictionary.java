package ru.job4j.dictionary;

import ru.job4j.search.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Class PhoneDictionary
 *
 * @author Petr B.
 * @since 27.08.2019
 */
public class PhoneDictionary {
    private List<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Вернуть список всех пользователей, который содержат key в любых полях.
     * @param key Ключ поиска.
     * @return Список подощедщих пользователей.
     */
    public List<Person> find(String key) {
        List<Person> result = new ArrayList<>();
        for (Person coincidence : this.persons) {
            if (coincidence.getName().contains(key) || coincidence.getSurname().contains(key)
                    || coincidence.getPhone().contains(key) || coincidence.getAddress().contains(key)) {
                result.add(coincidence);
            }
        }
        return result;
    }
}