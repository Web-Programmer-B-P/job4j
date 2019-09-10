package ru.job4j.convert;

import ru.job4j.convert.model.Student;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Class Convert
 *
 * @author Petr B.
 * @since 09.09.2019, 19:14
 */
public class Convert {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student(1, "Vasiliy", "Ivanov"),
                new Student(1, "Vasliy", "Ivanov"),
                new Student(6, "Igor", "Shtekker")
        );
        System.out.println(
                students.stream()
                        .collect(Collectors.toMap(Student::getLastName, student -> student, (s1, s2) -> s1))
        );
    }

}
