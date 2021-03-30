package com.epam.jwd.service;

import com.epam.jwd.model.Point;
import com.epam.jwd.model.Square;

import java.util.Arrays;

public class SquareService extends ShapeService<Square> {

    @Override
    public boolean isValid(Square shape) {
        double[] arrOfSidesLength = calcSidesLength(shape);
        Arrays.sort(arrOfSidesLength);

        return arrOfSidesLength[0] == arrOfSidesLength[3] &&
                arrOfSidesLength[4] == arrOfSidesLength[5];
    }

    private static double[] calcSidesLength(Square square) {
        Point[] points = square.getPoints();
        double[] sidesLength = new double[6];

/*        sidesLength[0] = PointService.getLenBetweenPoints(points[0], points[1]);
        sidesLength[1] = PointService.getLenBetweenPoints(points[0], points[2]);
        sidesLength[2] = PointService.getLenBetweenPoints(points[0], points[3]);
        sidesLength[3] = PointService.getLenBetweenPoints(points[1], points[2]);
        sidesLength[4] = PointService.getLenBetweenPoints(points[1], points[3]);
        sidesLength[5] = PointService.getLenBetweenPoints(points[2], points[3]);*/

        int index = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                sidesLength[index] = PointService.getLenBetweenPoints(points[i], points[j]);
                index++;
            }
        }


        return sidesLength;
    }

}
