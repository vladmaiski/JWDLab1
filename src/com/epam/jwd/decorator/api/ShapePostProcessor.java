package com.epam.jwd.decorator.api;

import com.epam.jwd.decorator.impl.ShapeExistencePostProcessing;
import com.epam.jwd.exception.ShapeNotExistException;
import com.epam.jwd.model.MultiAngleShape;

public interface ShapePostProcessor {

    MultiAngleShape process(MultiAngleShape shape) throws ShapeNotExistException;

}
