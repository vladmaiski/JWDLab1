package com.epam.jwd.model;

import org.apache.logging.log4j.*;

public abstract class Shape {

    private static final String ARGUMENT_AMOUNT_EXCEPTION_MSG = "Incorrect amount of points in ";
    private static final String ILLEGAL_VALUE_EXCEPTION_MSG = "Point can't be null in ";
    private static final Logger LOGGER = LogManager.getLogger();

    private final Point[] points;
    private final String name;

    public Shape(String name, int pointsAmount, Point... points) {
        if (points == null || points.length != pointsAmount) {
            String message = ARGUMENT_AMOUNT_EXCEPTION_MSG + this.getClass();
            LOGGER.error(message);
            throw new IllegalArgumentException(message);
        }
        this.points = new Point[pointsAmount];
        for (int i = 0; i < pointsAmount; i++) {
            if (points[i] == null) {
                String message = ILLEGAL_VALUE_EXCEPTION_MSG + this.getClass();
                LOGGER.error(message);
                throw new IllegalArgumentException(message);
            }
            this.points[i] = points[i];
        }
        this.name = name;
    }

    public Point[] getPoints() {
        return points;
    }

    @Override
    public String toString() {
        StringBuilder squareString = new StringBuilder();
        squareString.append(name).append("{");
        for (Point point : getPoints()) {
            squareString.append(point).append(" ");
        }
        squareString.append("}");
        return squareString.toString();
    }

}
