package com.epam.jwd.decorator.impl;

import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.decorator.api.ShapeFactoryAbstractDecorator;
import com.epam.jwd.decorator.api.ShapePreProcessor;
import com.epam.jwd.exception.ShapeException;
import com.epam.jwd.exception.ShapeNotExistException;
import com.epam.jwd.factory.api.ShapeFactory;
import com.epam.jwd.model.Shape;
import com.epam.jwd.model.simple.Point;

public class PreProcessingShapeFactory extends ShapeFactoryAbstractDecorator {

    private final ShapePreProcessor preProcessor = ShapePointsValidator.getInstance();

    public PreProcessingShapeFactory(ShapeFactory factory) {
        super(factory);
    }

    @Override
    public Shape createShape(ShapeType type, Point... points) throws ShapeException {
        if (type == null) {
            throw new IllegalArgumentException("Type is null");
        }

        if (!preProcessor.process(points)) {
            throw new ShapeNotExistException("Shape is not valid");
        }

        return factory.createShape(type, points);
    }
}
