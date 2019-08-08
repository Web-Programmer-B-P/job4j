package ru.job4j.programmer;

import ru.job4j.engineer.Engineer;

public class Programmer extends Engineer {
    private String language;
    private String typeOfDirection;
    private String typeOfOs;

    public String getLanguage() {
        return language;
    }

    public String getTypeOfDirection() {
        return typeOfDirection;
    }

    public String getTypeOfOs() {
        return typeOfOs;
    }
}
