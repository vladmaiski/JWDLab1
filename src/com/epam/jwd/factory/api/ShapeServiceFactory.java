package com.epam.jwd.factory.api;

import com.epam.jwd.model.Shape;
import com.epam.jwd.service.ShapeService;

public interface ShapeServiceFactory<E extends Shape> {

    ShapeService createService(String shapeName);

}
