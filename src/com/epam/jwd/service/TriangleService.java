package com.epam.jwd.service;

import com.epam.jwd.model.Triangle;

public class TriangleService extends ShapeService<Triangle>{

    @Override
    public boolean isValid(Triangle shape) {
        return !(shape.getArea() == 0);
    }
}
