package com.epam.jwd.factory.api;

import com.epam.jwd.model.Shape;
import com.epam.jwd.validator.api.ShapeValidator;

public interface ShapeServiceFactory<E extends Shape> {

    ShapeValidator<? extends E> createService(String shapeName);

}
