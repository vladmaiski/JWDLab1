package com.epam.jwd.model;

import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.strategy.api.ShapePropertiesStrategy;

public abstract class MultiAngleShape extends Shape implements Cloneable {

    private final ShapePropertiesStrategy strategy;

    public MultiAngleShape(ShapeType shapeType, ShapePropertiesStrategy strategy, Point... points) {
        super(shapeType, points);
        this.strategy = strategy;
    }

    @Override
    public MultiAngleShape clone() {
        try {
            return (MultiAngleShape) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            throw new IllegalStateException("Can't clone");
        }
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