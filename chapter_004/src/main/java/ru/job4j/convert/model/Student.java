package ru.job4j.convert.model;

import java.util.Objects;

/**
 * Class Student
 *
 * @author Petr B.
 * @since 09.09.2019, 19:16
 */
public class Student {
    private int scope;
    private String firstName;
    private String lastName;

    public Student(int scope, String firstName, String lastName) {
        this.scope = scope;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getScope() {
        return scope;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
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
                && Objects.equals(firstName, student.firstName)
                && Objects.equals(lastName, student.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scope, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Student{"
                + "scope=" + scope
                + ", firstName='" + firstName
                + '\''
                + ", lastName='" + lastName
                + '\''
                + '}';
    }
}
