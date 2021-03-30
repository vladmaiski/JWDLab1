package com.epam.jwd.service;

import com.epam.jwd.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PointService {

    private static final Logger LOGGER = LogManager.getLogger();

    public void printPoints(Point[] points) {
        for (Point point : points) {
            LOGGER.info(point);
        }
    }

    public static double getLenBetweenPoints(Point firstPoint, Point secondPoint) {
        double deltaX = secondPoint.getCoordinateX() - firstPoint.getCoordinateX();
        double deltaY = secondPoint.getCoordinateY() - firstPoint.getCoordinateY();

        return Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
    }

}
