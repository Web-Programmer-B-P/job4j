package ru.job4j.labmda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

/**
 * Class Calculator
 *
 * @author Petr B.
 * @since 08.09.2019, 8:20
 */
public class Calculator {
    public void multiple(int start, int finish, int value,
                         BiFunction<Integer, Integer, Double> op,
                         Consumer<Double> media) {
        for (int index = start; index != finish; index++) {
           media.accept(op.apply(value, index));
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        calc.multiple(
                1, 10, 2,
                (value, index) -> {
                    double result = value * index;
                    System.out.printf("Multiple ", "%s * s% = %n", value, index, result);
                    return result;
                },
                System.out::println
        );
    }
}
