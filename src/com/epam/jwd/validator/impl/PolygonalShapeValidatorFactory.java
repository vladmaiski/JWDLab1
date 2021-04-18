package com.epam.jwd.validator.impl;

import com.epam.jwd.constant.ShapeName;
import com.epam.jwd.factory.api.ShapeServiceFactory;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.validator.api.ShapeValidator;

public class PolygonalShapeValidatorFactory implements ShapeServiceFactory<MultiAngleShape> {

    private static final PolygonalShapeValidatorFactory INSTANCE = new PolygonalShapeValidatorFactory();

    private PolygonalShapeValidatorFactory() {
    }

    public static PolygonalShapeValidatorFactory getInstance() {
        return INSTANCE;
    }

    public ShapeValidator<? extends MultiAngleShape> createService(String shapeName) {
        switch (shapeName) {
            case ShapeName.SQUARE:
                return SquareValidator.getInstance();
            case ShapeName.TRIANGLE:
                return TriangleValidator.getInstance();
            case ShapeName.POLYGON:
                return PolygonValidator.getInstance();
        }
        throw new IllegalArgumentException("Incorrect multi angle shape " + shapeName);
    }

}