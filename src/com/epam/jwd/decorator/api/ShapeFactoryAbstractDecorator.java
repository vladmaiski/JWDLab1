package com.epam.jwd.decorator.api;

import com.epam.jwd.factory.api.ShapeFactory;

public abstract class ShapeFactoryAbstractDecorator implements ShapeFactory {

    protected final ShapeFactory factory;

    public ShapeFactoryAbstractDecorator(ShapeFactory factory) {
        this.factory = factory;
    }

}
