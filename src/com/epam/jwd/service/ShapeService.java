package com.epam.jwd.service;

import com.epam.jwd.model.Shape;

public interface ShapeService<E extends Shape> {

    boolean isValid(E shape);

}