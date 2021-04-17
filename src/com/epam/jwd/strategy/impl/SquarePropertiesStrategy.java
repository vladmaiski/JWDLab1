package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.service.PointService;
import com.epam.jwd.strategy.api.ShapePropertiesStrategy;

public enum SquarePropertiesStrategy implements ShapePropertiesStrategy {
    INSTANCE;

    //Enum Singleton

    @Override
    public double calculateArea(MultiAngleShape shape) {
        double sideLength = calculateSideLen(shape);

        return Math.pow(sideLength, 2);
    }

    @Override
    public double calculatePerimeter(MultiAngleShape shape) {
        double sideLength = calculateSideLen(shape);

        return sideLength * 4;
    }

    public double calculateSideLen(MultiAngleShape shape) {
        PointService pointService = PointService.getInstance();
        return pointService.calcLenBetweenPoints(shape.getPoints()[0], shape.getPoints()[1]);
    }

}
