package com.epam.jwd.model.polygonal;

import com.epam.jwd.constant.ShapeName;
import com.epam.jwd.model.MultiAngleShape;
import com.epam.jwd.model.simple.Point;
import com.epam.jwd.strategy.api.ShapePropertiesStrategy;

public class Square extends MultiAngleShape {

    Square(ShapePropertiesStrategy strategy, Point... points) {
        super(ShapeName.SQUARE, strategy, points);
    }

}
