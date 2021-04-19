package com.epam.jwd.model;

import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.strategy.api.ShapePropertiesStrategy;

public abstract class MultiAngleShape extends Shape {

    private final ShapePropertiesStrategy strategy;

    public MultiAngleShape(ShapeType shapeType, ShapePropertiesStrategy strategy, Point... points) {
        super(shapeType, points);
        this.strategy = strategy;
    }

    public double calculateArea() {
        return strategy.calculateArea(this);
    }

    public double calculatePerimeter() {
        return strategy.calculatePerimeter(this);
    }

    public ShapePropertiesStrategy getStrategy() {
        return strategy;
    }
}