package com.epam.jwd.factory.api;

import com.epam.jwd.constant.ShapeType;
import com.epam.jwd.exception.ShapeException;
import com.epam.jwd.model.Shape;
import com.epam.jwd.model.simple.Point;

public interface ShapeFactory {

    Shape createShape(ShapeType type, Point... points) throws ShapeException;
}
