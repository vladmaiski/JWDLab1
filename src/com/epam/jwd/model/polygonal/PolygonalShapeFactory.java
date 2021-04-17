package com.epam.jwd.model.polygonal;

import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.exception.ShapeException;
import com.epam.jwd.factory.api.ShapeFactory;
import com.epam.jwd.model.Shape;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.strategy.impl.PolygonalShapePropertiesStrategy;
import com.epam.jwd.strategy.impl.SquarePropertiesStrategy;
import com.epam.jwd.strategy.impl.TrianglePropertiesStrategy;

public class PolygonalShapeFactory implements ShapeFactory {

    private static PolygonalShapeFactory instance;

    private PolygonalShapeFactory() {
    }

    public static PolygonalShapeFactory getInstance() {
        if (instance == null) {
            return instance = new PolygonalShapeFactory();
        }
        return instance;
    }

    @Override
    public Shape createShape(ShapeType type, Point... points) throws ShapeException {
        switch (type) {
            case TRIANGLE:
                return new Triangle(TrianglePropertiesStrategy.getInstance(), points);
            case SQUARE:
                return new Square(SquarePropertiesStrategy.INSTANCE, points);
            case POLYGON:
                return new Polygon(PolygonalShapePropertiesStrategy.getInstance(), points);
            default:
                throw new IllegalArgumentException(type.name());
        }
    }

}

