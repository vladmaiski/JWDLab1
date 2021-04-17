package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.service.PointService;
import com.epam.jwd.strategy.api.ShapePropertiesStrategy;

public class TrianglePropertiesStrategy implements ShapePropertiesStrategy {

    //Lazy singleton
    private static volatile TrianglePropertiesStrategy instance;

    private TrianglePropertiesStrategy() {

    }

    public static TrianglePropertiesStrategy getInstance() {
        TrianglePropertiesStrategy localInstance = instance;
        if (localInstance == null) {
            synchronized (TrianglePropertiesStrategy.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new TrianglePropertiesStrategy();
                }
            }
        }
        return localInstance;
    }

    @Override
    public double calculateArea(MultiAngleShape shape) {
        double[] sidesLen = calculateSidesLen(shape);
        double semiPerimeter = (sidesLen[0] + sidesLen[1] + sidesLen[2]) / 2;
        return Math.sqrt(semiPerimeter
                * (semiPerimeter - sidesLen[0])
                * (semiPerimeter - sidesLen[1])
                * (semiPerimeter - sidesLen[2]));
    }

    //S:=sqrt(p * (p - a) * (p - b) * (p - c))
    //p := (a + b + c) / 2

    private double[] calculateSidesLen(MultiAngleShape shape) {
        PointService pointService = PointService.getInstance();
        Point[] points = shape.getPoints();
        double[] sides = new double[points.length];
        sides[0] = pointService.calcLenBetweenPoints(points[0], points[1]);
        sides[1] = pointService.calcLenBetweenPoints(points[0], points[2]);
        sides[2] = pointService.calcLenBetweenPoints(points[1], points[2]);
        return sides;
    }

    @Override
    public double calculatePerimeter(MultiAngleShape shape) {
        double[] sides = calculateSidesLen(shape);
        double perimeter = 0;
        for (double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }

}
