package com.kb.carWorkshop.enums;

public class Color {
    BLACK("Black"),
    WHITE("White"),
    SILVER("Silver"),
    GREY("Grey"),
    BLUE("Blue"),
    RED("Red"),
    BROWN("Brown"),
    GREEN("Green"),
    YELLOW("Yellow"),
    PINK("Pink"),
    PURPLE("Purple");

    private final String value;

    Color(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
