package com.epam.jwd.validator.impl;

import com.epam.jwd.model.simple.Line;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.validator.api.ShapeValidator;

public class LineValidator implements ShapeValidator<Line> {

    private static LineValidator instance;

    private LineValidator() {
    }

    public static LineValidator getInstance() {
        if (instance == null) {
            instance = new LineValidator();
        }
        return instance;
    }

    @Override
    public boolean isValid(Line shape) {
        Point[] points = shape.getPoints();
        return !points[0].equals(points[1]);
    }

}
