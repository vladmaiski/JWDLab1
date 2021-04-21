package com.epam.jwd.factory.api;

import com.epam.jwd.model.MultiAngleShape;

public interface ApplicationContext {

    ShapeFactory<MultiAngleShape> createShapeFactory();

}
