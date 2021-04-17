package com.epam.jwd.service.validator;

import com.epam.jwd.model.polygonal.Square;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.service.PointService;
import com.epam.jwd.service.ShapeService;

import java.util.Arrays;

public class SquareValidator implements ShapeService<Square> {

    private static final SquareValidator INSTANCE = new SquareValidator();

    private SquareValidator() {
    }

    public static SquareValidator getInstance() {
        return INSTANCE;
    }

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

        int index = 0;
        PointService pointService = PointService.getInstance();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 4; j++) {
                sidesLength[index] = pointService.calcLenBetweenPoints(points[i], points[j]);
                index++;
            }
        }

        return sidesLength;
    }

}
