package ru.job4j.convert;

import ru.job4j.convert.model.Student;

import java.util.Arrays;
import java.util.List;
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
                new Student(2, "Vasiliy", "Ivanov"),
                new Student(1, "Vladimir", "Petrov"),
                new Student(6, "Igor", "Shtekker")
        );
        System.out.println(students.stream().distinct().collect(Collectors.toMap(
                Student::getLastName,
                student -> student))
        );
    }

}
