package ru.job4j.calculate;

/**
 * Class Calculate
 * Класс для вычисления арифметических операций + - * /
 * @author Petr B.
 * @since 27.07.2019
 * @version 1
 */
public class Calculate {
    public static void main(String[] args) {
        add(1, 1);
        div(10, 3);
        multiply(5, 3);
        subtrack(5, 3);
    }

    /**
     * Сложение
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void add(double first, double second) {
        double result =  first + second;
        System.out.println(first + "+" + second + " = " + result);
    }

    /**
     * Деление
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void div(double first, double second) {
        double result =  first / second;
        System.out.println(first + "/" + second + " = " + result);
    }

    /**
     * Произведение
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void multiply(double first, double second) {
        double result =  first * second;
        System.out.println(first + "*" + second + " = " + result);
    }

    /**
     * Вычитание
     * @param first первый аргумент
     * @param second второй аргумент
     */
    public static void subtrack(double first, double second) {
        double result =  first - second;
        System.out.println(first + "-" + second + " = " + result);
    }

}
