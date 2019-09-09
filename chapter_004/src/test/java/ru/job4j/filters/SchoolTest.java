package ru.job4j.filters;

import org.junit.Test;
import ru.job4j.filters.model.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class SchoolTest
 *
 * @author Petr B.
 * @since 09.09.2019, 11:11
 */
public class SchoolTest {
    @Test
    public void classA() {
        School input = new School();
        List<Student> students = Arrays.asList(new Student(70), new Student(30), new Student(55),
                new Student(100));
        Predicate<Student> pred = new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getScope() >= 70;
            }
        };
        List<Student> result = input.collect(students,  pred);
        assertThat(result.toString(), is("[Student{scope=70}, Student{scope=100}]"));
    }

    @Test
    public void classB() {
        School input = new School();
        List<Student> students = Arrays.asList(new Student(65), new Student(30), new Student(55),
                new Student(77));
        Predicate<Student> pred = new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getScope() > 50 && student.getScope() < 70;
            }
        };
        List<Student> result = input.collect(students,  pred);
        assertThat(result.toString(), is("[Student{scope=55}, Student{scope=65}]"));
    }

    @Test
    public void classC() {
        School input = new School();
        List<Student> students = Arrays.asList(new Student(65), new Student(30), new Student(55),
                new Student(18));
        Predicate<Student> pred = new Predicate<Student>() {
            @Override
            public boolean test(Student student) {
                return student.getScope() > 0 && student.getScope() < 50;
            }
        };
        List<Student> result = input.collect(students,  pred);
        assertThat(result.toString(), is("[Student{scope=18}, Student{scope=30}]"));
    }
}
