package com.epam.jwd.storage.api;

import com.epam.jwd.model.Shape;

public interface ShapeStorage<E extends Shape> {

    void addShape(E shape);

}
