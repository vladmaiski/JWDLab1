package com.epam.jwd.validator.impl;

import com.epam.jwd.model.polygonal.Triangle;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.service.PointService;
import com.epam.jwd.validator.api.ShapeValidator;

public class TriangleValidator implements ShapeValidator<Triangle> {

    private static TriangleValidator instance;

    private TriangleValidator() {
    }

    public static TriangleValidator getInstance() {
        if (instance == null) {
            instance = new TriangleValidator();
        }
        return instance;
    }

    @Override
    public boolean isValid(Triangle shape) {
        double[] arrOfSidesLength = calcFigureSidesLength(shape);

        return arrOfSidesLength[0] < (arrOfSidesLength[1] + arrOfSidesLength[2])
                && arrOfSidesLength[1] < (arrOfSidesLength[0] + arrOfSidesLength[2])
                && arrOfSidesLength[2] < (arrOfSidesLength[0] + arrOfSidesLength[1]);
    }

    public double[] calcFigureSidesLength(Triangle shape) {
        Point[] points = shape.getPoints();
        double[] arrOfSidesLength = new double[3];
        PointService pointService = PointService.getInstance();
        arrOfSidesLength[0] = pointService.calcLenBetweenPoints(points[0], points[1]);
        arrOfSidesLength[1] = pointService.calcLenBetweenPoints(points[0], points[2]);
        arrOfSidesLength[2] = pointService.calcLenBetweenPoints(points[1], points[2]);

        return arrOfSidesLength;
    }

}
