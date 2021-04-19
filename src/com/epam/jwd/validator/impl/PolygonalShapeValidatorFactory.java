package com.epam.jwd.validator.impl;

import com.epam.jwd.constant.ShapeType;
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

    public ShapeValidator<? extends MultiAngleShape> createService(ShapeType shapeType) {
        switch (shapeType) {
            case SQUARE:
                return SquareValidator.getInstance();
            case TRIANGLE:
                return TriangleValidator.getInstance();
            case POLYGON:
                return PolygonValidator.getInstance();
        }
        throw new IllegalArgumentException("Incorrect multi angle shape " + shapeType.name());
    }

}