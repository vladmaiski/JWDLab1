package com.epam.jwd.model;

public class Square extends Shape {

    private static final int POINTS_AMOUNT = 4;
    private static final String SHAPE_NAME = "Square";

    public Square(Point... points) {
        super(SHAPE_NAME, POINTS_AMOUNT, points);
    }

}
