package ru.job4j.student;

import ru.job4j.student.model.Student;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class StudentList
 *
 * @author Petr B.
 * @since 12.09.2019, 8:24
 */
public class StudentList {
    List<Student> levelOf(List<Student> students, int bound) {
        students.sort(new Student());
        return students.stream()
                .flatMap(Stream::ofNullable)
                .takeWhile(el -> el.getScope() > bound)
                .collect(Collectors.toList());
    }
}
