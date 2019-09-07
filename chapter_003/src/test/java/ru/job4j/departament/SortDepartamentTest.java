package ru.job4j.departament;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Class SortDepartamentTest
 *
 * @author Petr B.
 * @since 06.09.2019, 15:41
 */
public class SortDepartamentTest {
    @Test
    public void formedGroup() {
        SortDepartament input = new SortDepartament();
        String[] departamentCodes = {"K1\\SK1\\SSK1", "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2", "K2", "K1\\SK1\\SSK2", "K1\\SK2", "K1\\SK1", "K2\\SK1"};
        String[] names = {"K1", "K2"};
        String result = Arrays.toString(input.formedGroup(names, departamentCodes));
        assertThat(result, is("[K1, K1\\SK1\\SSK1, K1\\SK1\\SSK2, K1\\SK2, K1\\SK1, K2, K2\\SK1\\SSK1, K2\\SK1\\SSK2, K2\\SK1]"));
    }

    @Test
    public void sortAsc() {
        SortDepartament input = new SortDepartament();
        String[] data = {"K1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K1\\SK1", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K2\\SK1"};
        String result = Arrays.toString(input.sortAsc(data));
        assertThat(result, is("[K1, K1\\SK1, K1\\SK1\\SSK1, K1\\SK1\\SSK2, K1\\SK2, K2, K2\\SK1, K2\\SK1\\SSK1, K2\\SK1\\SSK2]"));
    }

    @Test
    public void sortDesc() {
        SortDepartament input = new SortDepartament();
        String[] data = {"K1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2", "K1\\SK1", "K2", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2", "K2\\SK1"};
        String result = Arrays.toString(input.sortDesc(data));
        assertThat(result, is("[K2, K2\\SK1, K2\\SK1\\SSK2, K2\\SK1\\SSK1, K1, K1\\SK2, K1\\SK1, K1\\SK1\\SSK2, K1\\SK1\\SSK1]"));
    }

    @Test
    public void compareLeftLessThanRight() {
        SortDepartament input = new SortDepartament();
        int result = input.compare("K1", "K2\\SK1\\SSK1", 0);
        assertThat(result, lessThan(0));
    }

    @Test
    public void compareLeftMoreThanRight() {
        SortDepartament input = new SortDepartament();
        int result = input.compare("K1\\SK2", "K1\\SK1\\SSK2", 0);
        assertThat(result, greaterThan(0));
    }

    @Test
    public void compareLeftEqualRight() {
        SortDepartament input = new SortDepartament();
        int result = input.compare("K1\\SK2", "K1\\SK2", 0);
        assertThat(result, equalTo(0));
    }

    @Test
    public void compareLeftGreaterRightWhithFlag1() {
        SortDepartament input = new SortDepartament();
        int result = input.compare("K1", "K1\\SK1\\SSK1", 1);
        assertThat(result, greaterThan(0));
    }
}