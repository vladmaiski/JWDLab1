package com.epam.jwd.decorator.impl;

import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.decorator.api.ShapeFactoryAbstractDecorator;
import com.epam.jwd.decorator.api.ShapePostProcessor;
import com.epam.jwd.exception.ShapeException;
import com.epam.jwd.factory.api.ShapeFactory;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.model.simple.Point;

public class PostProcessingShapeFactory extends ShapeFactoryAbstractDecorator {

    private final ShapePostProcessor postProcessor = ShapeExistencePostProcessing.getInstance();

    public PostProcessingShapeFactory(ShapeFactory factory) {
        super(factory);
    }

    @Override
    public MultiAngleShape createShape(ShapeType type, Point... points) throws ShapeException {
        MultiAngleShape shape = factory.createShape(type, points);
        return postProcessor.process(shape);
    }

}
