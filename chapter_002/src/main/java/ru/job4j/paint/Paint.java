package ru.job4j.paint;

import ru.job4j.shape.Shape;
import ru.job4j.square.Square;
import ru.job4j.triangle.Triangle;

/**
 * Class Paint
 * Класс Paint служит для отрисовки фигур.
 * @author Petr B.
 * @version 1.0
 * @since 15.08.2019
 */
public class Paint {
    public void draw(Shape shape) {
        String object = shape.draw();
        int hight = 0;
        int width = 1;
        char symbolOutter = object.charAt(0);
        char symbolInner = '0';
        String result = "";
        if (shape.getClass().toString().equals("class ru.job4j.square.Square")) {
            for (int index = 0; index < shape.draw().length(); index++) {
                if (hight == 0 && object.charAt(index) != symbolOutter) {
                    symbolInner = object.charAt(index);
                    hight = index - 1;
                }

                if (((index + 1) < object.length()) && object.charAt(index) == symbolOutter
                        && object.charAt(index + 1) != symbolOutter) {
                    width++;
                }
            }

            for (int col = 0; col < hight; col++) {
                for (int row = 0; row < hight; row++) {
                    if (col == 0 || col == width) {
                        result += symbolOutter;
                    }

                    if ((col > 0 && col < width) && (row == 0 || row == hight - 1)) {
                        result += symbolOutter;
                    } else if ((col > 0 && col < width)) {
                        result += symbolInner;
                    }
                }
//                result += "\n";
            }
            System.out.println(result);
        }

        int start = 0;
        if (shape.getClass().toString().equals("class ru.job4j.triangle.Triangle")) {
            for (int index = 0; index < shape.draw().length(); index++) {
                if (start == 0 && object.charAt(index) != symbolOutter) {
                    symbolInner = object.charAt(index);
                    start = index - 1;
                    width = index * 2;
                }

                if (((index + 1) < object.length()) && object.charAt(index) == symbolOutter
                        && object.charAt(index + 1) != symbolOutter) {
                    hight++;
                }
            }

            for (int col = 0; col < hight; col++) {
                for (int row = 0; row <= width; row++) {
                    if (row > start && row < width - start) {
                        result += symbolInner;
                    } else {
                        result += ".";
                    }
                }
                start--;
//                result += "\n";
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Square());
        paint.draw(new Triangle());
    }
}
