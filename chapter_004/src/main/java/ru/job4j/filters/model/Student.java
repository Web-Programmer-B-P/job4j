package ru.job4j.filters.model;

import java.util.Objects;

/**
 * Class Student
 *
 * @author Petr B.
 * @since 09.09.2019, 11:02
 */
public class Student implements Comparable<Student> {
    private int scope;

    public Student(int scope) {
        this.scope = scope;
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
        return scope == student.scope;
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope);
    }

    @Override
    public String toString() {
        return "Student{"
                + "scope=" + scope
                + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.getScope() - o.getScope();
    }
}
