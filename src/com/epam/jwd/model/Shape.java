package com.epam.jwd.model;

import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.model.simple.Point;

public abstract class Shape {

    private final Point[] points;
    private final ShapeType shapeType;
    private final long ID;
    private static long availableID = 0;

    public Shape(ShapeType shapeType, Point... points) {
        this.points = points;
        this.shapeType = shapeType;
        this.ID = availableID++;
    }

    public long getID() {
        return ID;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder squareString = new StringBuilder();
        squareString.append(shapeType).append("{");
        for (Point point : getPoints()) {
            squareString.append(point).append(" ");
        }
        squareString.append("}");
        return squareString.toString();
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

}
