package ru.job4j.dictionary;

import org.junit.Test;
import ru.job4j.dictionary.model.Person;

import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PhoneDictionaryTest {
    @Test
    public void whenFindByName() {
        PhoneDictionary phones = new PhoneDictionary();
        phones.add(
                new Person("This", "Is", "234329956", "Voronezh")
        );
        List<Person> persons = phones.find("56");
        assertThat(persons.iterator().next().getSurname(), is("Is"));
    }
}
