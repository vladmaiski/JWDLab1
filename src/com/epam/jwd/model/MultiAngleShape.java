package com.epam.jwd.model;

import com.epam.jwd.model.simple.Point;
import com.epam.jwd.strategy.api.ShapePropertiesStrategy;

public abstract class MultiAngleShape extends Shape {

    private final ShapePropertiesStrategy strategy;

    public MultiAngleShape(String name, ShapePropertiesStrategy strategy, Point... points) {
        super(name, points);
        this.strategy = strategy;
    }

    public double calcArea() {
        return strategy.calculateArea(this);
    }

    public double calculatePerimeter() {
        return strategy.calculatePerimeter(this);
    }

}