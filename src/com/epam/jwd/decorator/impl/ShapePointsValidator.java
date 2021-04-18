package com.epam.jwd.decorator.impl;

import com.epam.jwd.decorator.api.ShapePreProcessor;
import com.epam.jwd.exception.ShapeException;
import com.epam.jwd.exception.ShapeNotExistException;
import com.epam.jwd.model.simple.Point;

import java.util.Arrays;

public class ShapePointsValidator implements ShapePreProcessor {

    private static ShapePointsValidator instance;

    private ShapePointsValidator() {
    }

    public static ShapePointsValidator getInstance() {
        if (instance == null) {
            instance = new ShapePointsValidator();
        }
        return instance;
    }

    @Override
    public boolean process(Point... points) throws ShapeException {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++)
                if (points[i].equals(points[j])) {
                    throw new ShapeNotExistException("Figure: " + Arrays.toString(points) + " - must have different points");
                }
        }
        return true;
    }

}
