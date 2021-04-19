package com.epam.jwd.storage.impl;

import com.epam.jwd.builder.PolygonalShapeCriteria;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.storage.api.ShapeStorage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class PolygonalShapeStorage implements ShapeStorage<MultiAngleShape> {

    private final ArrayList<MultiAngleShape> STORAGE = new ArrayList<>();

    private static PolygonalShapeStorage instance;

    private PolygonalShapeStorage() {
    }

    static PolygonalShapeStorage getInstance() {
        if (instance == null) {
            instance = new PolygonalShapeStorage();
        }
        return instance;
    }

    @Override
    public void addShape(MultiAngleShape shape) {
        STORAGE.add(shape);
    }

    public ArrayList<MultiAngleShape> getStorage() {
        return STORAGE;
    }

    List<? extends MultiAngleShape> figuresByCriteria(PolygonalShapeCriteria figureCriteria) {
        return STORAGE.stream()
                .filter(figure -> figureCriteria.getShapeType() == null
                        || figureCriteria.getShapeType() == figure.getShapeType())
                .filter(figure -> figureCriteria.getShapeId() == -1
                        || figureCriteria.getShapeId() == figure.getID())
                .filter(figure -> figureCriteria.getShapePerimeter() == -1
                        || figureCriteria.getShapePerimeter() == figure.getStrategy().calculatePerimeter(figure))
                .filter(figure -> figureCriteria.getShapeArea() == -1
                        || figureCriteria.getShapeArea() == figure.getStrategy().calculateArea(figure))
                .collect(Collectors.toList());
    }

    void removeShape(int shapeId) {
        MultiAngleShape shape = findShape(shapeId);
        STORAGE.remove(shape);
    }

    MultiAngleShape findShape(long figureId) {
        return STORAGE.stream()
                .filter((figureFromStorage) -> figureFromStorage.getID() == figureId)
                .findFirst()
                .orElse(null);
    }

    void updateShape(int id, MultiAngleShape newShape) {
        MultiAngleShape shape = findShape(id);
        if (Objects.nonNull(shape)) {
            int index = STORAGE.indexOf(shape);
            STORAGE.set(index, newShape);
        }
    }

}
