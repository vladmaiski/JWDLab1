package com.epam.jwd.storage.impl;

import com.epam.jwd.builder.PolygonalShapeCriteria;
import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.exception.ShapeException;
import com.epam.jwd.factory.api.ShapeFactory;
import com.epam.jwd.factory.impl.SimpleApplicationContext;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.model.Shape;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.storage.api.ShapeCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShapeCrudImpl implements ShapeCrud {

    private final ShapeFactory POLYGONAL_FIGURE_FACTORY = SimpleApplicationContext.getInstance().createShapeFactory();
    private final PolygonalShapeStorage STORAGE = PolygonalShapeStorage.getInstance();

    @Override
    public Shape createShape(ShapeType type, Point... points) throws ShapeException {
        MultiAngleShape newShape = POLYGONAL_FIGURE_FACTORY.createShape(type, points);
        STORAGE.addShape(newShape);
        return newShape;
    }

    @Override
    public List<MultiAngleShape> multiCreateShape(Map<ShapeType, Point[]> shapeMap) throws ShapeException {
        if (shapeMap == null || shapeMap.size() == 0) {
            throw new ShapeException("Map should be not null/empty");
        }
        List<MultiAngleShape> createdShapes = new ArrayList<>();
        for (Map.Entry<ShapeType, Point[]> entry : shapeMap.entrySet()) {
            MultiAngleShape shape = POLYGONAL_FIGURE_FACTORY.createShape(entry.getKey(), entry.getValue());
            createdShapes.add(shape);
            STORAGE.addShape(shape);
        }
        return createdShapes;
    }

    @Override
    public void deleteShape(int shapeID) {
        if (shapeID < 0) {
            throw new IllegalArgumentException("Figure ID must be > 0");
        }

        STORAGE.removeShape(shapeID);
    }

    @Override
    public void updateShape(int id, MultiAngleShape shape) {
        if (id < 0) {
            throw new IllegalArgumentException("Figure ID must be > 0");
        }

        if (shape == null) {
            throw new IllegalArgumentException("Shape should be bot null");
        }

        STORAGE.updateShape(id, shape);
    }

    @Override
    public MultiAngleShape findShapesById(long shapeID) {
        if (shapeID < 0) {
            throw new IllegalArgumentException("Figure ID must be > 0");
        }
        return STORAGE.findShape(shapeID);
    }

    @Override
    public List<? extends MultiAngleShape> findShapesByCriteria(PolygonalShapeCriteria criteria) {
        if (criteria == null) {
            throw new IllegalArgumentException("Criteria must be not null");
        }
        return STORAGE.figuresByCriteria(criteria);
    }

}
