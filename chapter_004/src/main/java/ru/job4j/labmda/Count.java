package ru.job4j.labmda;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

/**
 * Class Count
 *
 * @author Petr B.
 * @since 08.09.2019, 12:22
 */

/**
 * Class Count
 *
 * @author Petr B.
 * @since 08.09.2019, 11:37
 */
public class Count {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index < end; index++) {
            result.add(func.apply((double) index));
        }
        return result;
    }
}
