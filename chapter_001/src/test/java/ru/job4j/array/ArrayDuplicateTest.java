package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.Arrays;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        String[] array = new String[] {"Привет", "Мир", "Привет", "Супер", "Мир"};
        ArrayDuplicate arrayWithout = new ArrayDuplicate();
        String[] result = arrayWithout.remove(array);
        String[] expect = new String[] {"Привет", "Мир", "Супер"};
        assertThat(result, is(expect));
    }

    @Test
    public void whenRemoveDuplicates() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
        String[] array = new String[] {"Hello", "World", "Some", "Super", "World", "Some", "Array", "World"};
        ArrayDuplicate arrayWithout = new ArrayDuplicate();
        String[] result = arrayWithout.remove(array);
        String[] expect = new String[] {"Hello", "World", "Some", "Super", "Array"};
        assertThat(result, is(expect));
    }
}