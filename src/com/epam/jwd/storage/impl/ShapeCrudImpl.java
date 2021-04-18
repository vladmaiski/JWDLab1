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

    @Override
    public Shape createShape(ShapeType type, Point... points) throws ShapeException {
        return POLYGONAL_FIGURE_FACTORY.createShape(type, points);
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
        }
        return createdShapes;
    }

    @Override
    public void deleteShape(int index) {

    }

    @Override
    public void updateFigure(int index, MultiAngleShape shape) {

    }

    @Override
    public List<MultiAngleShape> findShapesById(int figureId) {
        return null;
    }

    @Override
    public List<MultiAngleShape> findShapesByCriteria(PolygonalShapeCriteria criteria) {
        return null;
    }

}
