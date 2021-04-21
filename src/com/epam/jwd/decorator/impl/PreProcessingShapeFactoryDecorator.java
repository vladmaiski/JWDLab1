package com.epam.jwd.decorator.impl;

import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.decorator.api.ShapeFactoryAbstractDecorator;
import com.epam.jwd.decorator.api.ShapePreProcessor;
import com.epam.jwd.exception.ShapeException;
import com.epam.jwd.exception.ShapeNotExistException;
import com.epam.jwd.factory.api.ShapeFactory;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.model.simple.Point;

public class PreProcessingShapeFactoryDecorator extends ShapeFactoryAbstractDecorator {

    private final ShapePreProcessor[] preProcessor = new ShapePreProcessor[]{ShapePointsValidator.getInstance()};

    public PreProcessingShapeFactoryDecorator(ShapeFactory factory) {
        super(factory);
    }

    @Override
    public MultiAngleShape createShape(ShapeType type, Point... points) throws ShapeException {
        if (type == null) {
            throw new IllegalArgumentException("Type is null");
        }

        for (ShapePreProcessor preProcessor : preProcessor) {
            if (!preProcessor.process(points)) {
                throw new ShapeNotExistException("Shape is not valid");
            }
        }

        return factory.createShape(type, points);
    }
}
