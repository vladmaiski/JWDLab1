package com.epam.jwd.decorator.api;

import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.exception.ShapeException;
import com.epam.jwd.factory.api.ShapeFactory;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.model.simple.Point;

public abstract class ShapeFactoryAbstractDecorator implements ShapeFactory<MultiAngleShape> {

    protected final ShapeFactory<MultiAngleShape> factory;

    public ShapeFactoryAbstractDecorator(ShapeFactory<MultiAngleShape> factory) {
        this.factory = factory;
    }

    public abstract MultiAngleShape createShape(ShapeType type, Point... points) throws ShapeException;

}
