package com.epam.jwd.service;

import com.epam.jwd.constant.ShapeName;
import com.epam.jwd.factory.api.ShapeServiceFactory;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.service.validator.PolygonValidator;
import com.epam.jwd.service.validator.SquareValidator;
import com.epam.jwd.service.validator.TriangleValidator;

public class PolygonalShapeServiceFactory implements ShapeServiceFactory<MultiAngleShape> {

    private static final PolygonalShapeServiceFactory INSTANCE = new PolygonalShapeServiceFactory();

    private PolygonalShapeServiceFactory() {
    }

    public static PolygonalShapeServiceFactory getInstance() {
        return INSTANCE;
    }

    public ShapeService<? extends MultiAngleShape> createService(String shapeName) {
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