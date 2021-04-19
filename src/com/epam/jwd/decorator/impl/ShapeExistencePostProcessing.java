package com.epam.jwd.decorator.impl;

import com.epam.jwd.decorator.api.ShapePostProcessor;
import com.epam.jwd.exception.ShapeNotExistException;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.validator.api.ShapeValidator;
import com.epam.jwd.validator.impl.PolygonalShapeValidatorFactory;

public class ShapeExistencePostProcessing implements ShapePostProcessor {

    private static ShapeExistencePostProcessing instance;

    private ShapeExistencePostProcessing() {
    }

    public static ShapeExistencePostProcessing getInstance() {
        if (instance == null) {
            instance = new ShapeExistencePostProcessing();
        }
        return instance;
    }

    @Override
    public MultiAngleShape process(MultiAngleShape shape) throws ShapeNotExistException {
        PolygonalShapeValidatorFactory serviceFactory = PolygonalShapeValidatorFactory.getInstance();
        ShapeValidator multiAngelShapeShapeValidator = serviceFactory.createService(shape.getShapeType());
        if (!multiAngelShapeShapeValidator.isValid(shape)) {
            throw new ShapeNotExistException(shape.toString());
        }
        return shape;
    }
}
