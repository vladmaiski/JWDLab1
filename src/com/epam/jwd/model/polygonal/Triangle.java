package com.epam.jwd.model.polygonal;

import com.epam.jwd.constant.ShapeName;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.strategy.api.ShapePropertiesStrategy;

public class Triangle extends MultiAngleShape {

    Triangle(ShapePropertiesStrategy strategy, Point... points) {
        super(ShapeName.TRIANGLE, strategy, points);
    }

}
