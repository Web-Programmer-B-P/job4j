package ru.job4j.condition;

/**
 * Class Point
 *
 * @author Petr B.
 * @since 04.08.2019
 * @version 1
 */
public class Point {
    private int x;
    private int y;
    /**
     * Конструтор, который принимает начальное состояние объекта "точка"
     * @param first координата x
     * @param second координата y
     */
    public Point(int first, int second) {
        this.x = first;
        this.y = second;
    }

    public double distance(Point that) {
        return Math.sqrt((Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)));
    }

    public void info() {
        System.out.println(String.format("Point[%s, %s]", this.x, this.y));
    }
}
