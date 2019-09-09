package ru.job4j.filters;

import ru.job4j.filters.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class School
 *
 * @author Petr B.
 * @since 09.09.2019, 11:01
 */
public class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        return students.stream().sorted().filter(predict).collect(Collectors.toList());
    }
}
