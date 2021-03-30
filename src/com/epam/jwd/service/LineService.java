package com.epam.jwd.service;

import com.epam.jwd.model.Line;
import com.epam.jwd.model.Point;

public class LineService extends ShapeService<Line> {

    @Override
    public boolean isValid(Line shape) {
        Point[] points = shape.getPoints();
        return !points[0].equals(points[1]);
    }

}
