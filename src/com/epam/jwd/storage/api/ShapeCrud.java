package com.epam.jwd.storage.api;

import com.epam.jwd.builder.PolygonalShapeCriteria;
import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.exception.ShapeException;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.model.Shape;
import com.epam.jwd.model.simple.Point;

import java.util.List;
import java.util.Map;

public interface ShapeCrud {

    Shape createShape(ShapeType type, Point... points) throws ShapeException;

    List<MultiAngleShape> multiCreateShape(Map<ShapeType, Point[]> shapeMap) throws ShapeException;

    void deleteShape(int id);

    void updateShape(int id, MultiAngleShape shape);

    MultiAngleShape findShapesById(long figureId);

    List<? extends MultiAngleShape> findShapesByCriteria(PolygonalShapeCriteria criteria);

}
