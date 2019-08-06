package ru.job4j.condition;

public class Triangle {

    /**
     * Метод вычисления полупериметра по длинам сторон.
     *
     * Формула.
     *
     * (a + b + c) / 2
     *
     * @param a расстояние между точками a b
     * @param b расстояние между точками a c
     * @param c расстояние между точками b c
     * @return полуперимента.
     */
    public double period(Point a, Point b, Point c) {
        return (a.distance(b) + b.distance(c) + c.distance(a)) / 2;
    }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     * Подумайте какое надо написать условие, чтобы определить можно ли построить треугольник.
     *
     * @param a Длина от точки a b.
     * @param c Длина от точки b c.
     * @param b Длина от точки a c.
     * @return
     */
    private boolean exist(Point a, Point c, Point b) {
        if (a.distance(b) < (a.distance(c) + c.distance(b))
                && a.distance(c) < (a.distance(b) + c.distance(b))
                && c.distance(b) < (a.distance(b) + a.distance(c))) {
            return true;
        }
        return false;
    }

    /**
     * Метод должен вычислить площадь треугольника.
     *
     * Формула.
     *
     * √ p *(p - a) * (p - b) * (p - c)
     *
     * где √ - корень квадратный, для извлечения корня использовать метод Math.sqrt().
     *
     * @return Вернуть площадь, если треугольник существует или -1.
     */
    public double area(int x1, int y1, int x2, int y2, int x3, int y3) {
        double rsl = -1;
        Point a = new Point(x1, y1);
        Point b = new Point(x2, y2);
        Point c = new Point(x3, y3);
        a.distance(b);
        b.distance(c);
        c.distance(a);
        double p = period(a, b, c);
        if (this.exist(a, b, c)) {
            // написать формулу для расчета площади треугольника.
            rsl = Math.sqrt(p * (p - a.distance(b)) * (p - a.distance(c)) * (p - c.distance(b)));
        }
        return rsl;
    }
}
