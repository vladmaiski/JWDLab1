package com.epam.jwd.decorator.impl;

import com.epam.jwd.decorator.api.ShapePostProcessor;
import com.epam.jwd.exception.ShapeNotExistException;
import com.epam.jwd.model.Shape;
import com.epam.jwd.service.PolygonalShapeServiceFactory;
import com.epam.jwd.service.ShapeService;

public class ShapeExistencePostProcessing implements ShapePostProcessor {

    private static final ShapeExistencePostProcessing INSTANCE = new ShapeExistencePostProcessing();

    private ShapeExistencePostProcessing() {
    }

    public static ShapeExistencePostProcessing getInstance() {
        return INSTANCE;
    }

    @Override
    public Shape process(Shape shape) throws ShapeNotExistException {
        PolygonalShapeServiceFactory serviceFactory = PolygonalShapeServiceFactory.getInstance();
        ShapeService multiAngelShapeShapeService = serviceFactory.createService(shape.getName());
        if (!multiAngelShapeShapeService.isValid(shape)) {
            throw new ShapeNotExistException(shape.toString());
        }
        return shape;
    }
}
