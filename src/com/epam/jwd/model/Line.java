package com.epam.jwd.model;

public class Line extends Shape {

    private static final int POINTS_AMOUNT = 2;
    private static final String SHAPE_NAME = "Line";

    public Line(Point... points) {
        super(SHAPE_NAME, POINTS_AMOUNT, points);
    }
}
