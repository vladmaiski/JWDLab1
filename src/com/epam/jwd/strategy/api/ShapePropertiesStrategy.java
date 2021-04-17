package com.epam.jwd.strategy.api;

import com.epam.jwd.model.MultiAngleShape;

public interface ShapePropertiesStrategy {

    double calculateArea(MultiAngleShape shape);

    double calculatePerimeter(MultiAngleShape shape);

}
