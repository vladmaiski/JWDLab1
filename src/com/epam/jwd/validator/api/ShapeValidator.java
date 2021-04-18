package com.epam.jwd.validator.api;

import com.epam.jwd.model.Shape;

public interface ShapeValidator<E extends Shape> {

    boolean isValid(E shape);

}