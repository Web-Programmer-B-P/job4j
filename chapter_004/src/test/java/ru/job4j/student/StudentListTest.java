package ru.job4j.student;

import org.junit.Test;
import ru.job4j.student.model.Student;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Class StudentListTest
 *
 * @author Petr B.
 * @since 12.09.2019, 8:48
 */
public class StudentListTest {
    @Test
    public void studentsListSortedByParametr() {
        List<Student> input = Arrays.asList(null, new Student("Petr", 23),
                new Student("Aleks", 19), new Student("Dmitrie", 15), null);
        StudentList result = new StudentList();
        String exctend = "[Student{name='Dmitrie', scope=15}, Student{name='Aleks', scope=19}, Student{name='Petr', scope=23}]";
        assertThat(result.levelOf(input, 14).toString(), is(exctend));
    }
}
