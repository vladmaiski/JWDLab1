package com.epam.jwd.strategy.impl;

import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.service.PointService;
import com.epam.jwd.strategy.api.ShapePropertiesStrategy;

public class PolygonalShapePropertiesStrategy implements ShapePropertiesStrategy {

    //Another realization of singleton
    private static PolygonalShapePropertiesStrategy instance;

    private PolygonalShapePropertiesStrategy() {
    }

    public static PolygonalShapePropertiesStrategy getInstance() {
        if (instance == null) {
            return instance = new PolygonalShapePropertiesStrategy();
        }
        return instance;
    }

    @Override
    public double calculateArea(MultiAngleShape shape) {
        double[] figureSidesLength = calcSidesLength(shape);
        double numOfFigurePoints = shape.getPoints().length;

        return (Math.pow(figureSidesLength[0], 2) * numOfFigurePoints) / (4 * Math.tan(Math.PI / numOfFigurePoints));
    }

    @Override
    public double calculatePerimeter(MultiAngleShape shape) {
        double[] figuresSidesLength = calcSidesLength(shape);

        return figuresSidesLength[0] * figuresSidesLength.length;
    }

    private double[] calcSidesLength(MultiAngleShape shape) {
        PointService pointService = PointService.getInstance();
        int sidesAmount = shape.getPoints().length;
        double[] figureSidesLength = new double[sidesAmount];
        Point[] points = shape.getPoints();
        for (int i = 0; i < sidesAmount - 1; i++) {
            figureSidesLength[i] = pointService.calcLenBetweenPoints(points[i], points[i + 1]);
        }
        figureSidesLength[sidesAmount - 1] = pointService.calcLenBetweenPoints(points[0], points[sidesAmount - 1]);

        return figureSidesLength;
    }

}
