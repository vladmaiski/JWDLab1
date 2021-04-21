package com.epam.jwd.decorator.api;

import com.epam.jwd.decorator.impl.ShapePointsValidator;
import com.epam.jwd.exception.ShapeException;
import com.epam.jwd.model.simple.Point;

public interface ShapePreProcessor {

    boolean process(Point... points) throws ShapeException;

}
