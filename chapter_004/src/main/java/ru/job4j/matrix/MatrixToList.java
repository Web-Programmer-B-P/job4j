package ru.job4j.matrix;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class MatrixToList
 *
 * @author Petr B.
 * @since 10.09.2019, 13:21
 */
public class MatrixToList {
    public static void main(String[] args) {
        Integer[][] matrix = {{1, 2}, {3, 4}, {5, 6}};
        List<Integer> lis = Arrays.stream(matrix).flatMap(Stream::of).collect(Collectors.toList());
        System.out.println(lis);
    }
}
