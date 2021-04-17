package com.epam.jwd.service.validator;

import com.epam.jwd.model.polygonal.Triangle;
import com.epam.jwd.service.ShapeService;

public class TriangleValidator implements ShapeService<Triangle> {

    private static final TriangleValidator INSTANCE = new TriangleValidator();

    private TriangleValidator() {
    }

    public static TriangleValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean isValid(Triangle shape) {
        return false;
    }

}
