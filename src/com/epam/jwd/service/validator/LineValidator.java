package com.epam.jwd.service.validator;

import com.epam.jwd.model.simple.Line;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.service.ShapeService;

public class LineValidator implements ShapeService<Line> {

    private final LineValidator INSTANCE = new LineValidator();

    private LineValidator() {
    }

    public LineValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean isValid(Line shape) {
        Point[] points = shape.getPoints();
        return !points[0].equals(points[1]);
    }

}
