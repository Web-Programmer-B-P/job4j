package ru.job4j.square;

import ru.job4j.shape.Shape;

public class Square implements Shape {

    public String draw() {
        StringBuffer pic = new StringBuffer();
        pic.append("xxxxxxxx");
        pic.append("xccccccx");
        pic.append("xccccccx");
        pic.append("xccccccx");
        pic.append("xxxxxxxx");
        return pic.toString();
    }
}
