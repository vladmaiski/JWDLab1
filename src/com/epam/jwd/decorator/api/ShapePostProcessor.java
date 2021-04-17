package com.epam.jwd.decorator.api;

import com.epam.jwd.decorator.impl.ShapeExistencePostProcessing;
import com.epam.jwd.exception.ShapeNotExistException;
import com.epam.jwd.model.Shape;

public interface ShapePostProcessor {

    Shape process(Shape shape) throws ShapeNotExistException;

    static ShapePostProcessor newInstance() {
        return ShapeExistencePostProcessing.getInstance();
    }

}
