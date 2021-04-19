package com.epam.jwd.model.simple;

import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.model.Shape;

public class Line extends Shape {

    Line(Point... points) {
        super(ShapeType.LINE, points);
    }
}
