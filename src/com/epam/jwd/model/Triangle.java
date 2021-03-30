package com.epam.jwd.model;

import com.epam.jwd.service.PointService;

public class Triangle extends Shape {

    private static final int POINTS_AMOUNT = 3;
    private static final String SHAPE_NAME = "Triangle";

    public Triangle(Point... points) {
        super(SHAPE_NAME, POINTS_AMOUNT, points);
    }

    //S:=sqrt(p * (p - a) * (p - b) * (p - c))
    //p := (a + b + c) / 2

    public double[] calcSidesLen() {
        double[] sides = new double[POINTS_AMOUNT];
        Point[] points = getPoints();
        sides[0] = PointService.getLenBetweenPoints(points[0], points[1]);
        sides[1] = PointService.getLenBetweenPoints(points[0], points[2]);
        sides[2] = PointService.getLenBetweenPoints(points[1], points[2]);
        return sides;
    }

    public double getArea() {
        double[] sidesLen = calcSidesLen();
        double semiPerimeter = (sidesLen[0] + sidesLen[1] + sidesLen[2]) / 2;
        return Math.sqrt(semiPerimeter
                        * (semiPerimeter - sidesLen[0])
                        * (semiPerimeter - sidesLen[1])
                        * (semiPerimeter - sidesLen[2]));
    }

}
