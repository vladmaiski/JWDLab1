package com.epam.jwd.service.validator;

import com.epam.jwd.model.polygonal.Polygon;
import com.epam.jwd.service.PointService;
import com.epam.jwd.service.ShapeService;

public class PolygonValidator implements ShapeService<Polygon> {

    private static final PolygonValidator INSTANCE = new PolygonValidator();

    private PolygonValidator() {
    }

    public static PolygonValidator getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean isValid(Polygon shape) {
        double[] sidesLength = calcSidesLength(shape);

        for (int i = 0; i < sidesLength.length - 1; i++) {
            if (sidesLength[i] != sidesLength[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public double[] calcSidesLength(Polygon shape) {
        double[] sidesLength = new double[shape.getPoints().length];
        PointService pointService = PointService.getInstance();
        for (int i = 0; i < shape.getPoints().length - 1; i++) {
            sidesLength[i] = pointService.calcLenBetweenPoints(shape.getPoints()[i], shape.getPoints()[i + 1]);
        }
        sidesLength[shape.getPoints().length - 1] = pointService.calcLenBetweenPoints(shape.getPoints()[0],
                shape.getPoints()[shape.getPoints().length - 1]);

        return sidesLength;
    }

}
