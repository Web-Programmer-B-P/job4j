package ru.job4j.student.model;

import java.util.Comparator;
import java.util.Objects;

/**
 * Class Student
 *
 * @author Petr B.
 * @since 12.09.2019, 8:25
 */
public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student() {

    }

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    @Override
    public int compare(Student o1, Student o2) {
        if (o1 == null && o2 == null) {
            return 0;
        }
        if (o1 == null) {
            return -1;
        }
        if (o2 == null) {
            return 1;
        }
        return o1.getScope() - o2.getScope();
    }


    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return scope == student.scope
                && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, scope);
    }

    @Override
    public String toString() {
        return "Student{"
                + "name='" + name
                + '\''
                + ", scope=" + scope
                + '}';
    }
}
