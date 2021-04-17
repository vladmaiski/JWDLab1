package com.epam.jwd.model.simple;

import com.epam.jwd.model.Shape;

public class Line extends Shape {

    private static final String SHAPE_NAME = "Line";

    Line(Point... points) {
        super(SHAPE_NAME, points);
    }
}
