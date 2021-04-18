package com.epam.jwd.validator.impl;

import com.epam.jwd.model.polygonal.Triangle;
import com.epam.jwd.validator.api.ShapeValidator;

public class TriangleValidator implements ShapeValidator<Triangle> {

    private static TriangleValidator instance;

    private TriangleValidator() {
    }

    public static TriangleValidator getInstance() {
        if (instance == null) {
            instance = new TriangleValidator();
        }
        return instance;
    }

    @Override
    public boolean isValid(Triangle shape) {
        return false;
    }

}
