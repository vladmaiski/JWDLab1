package com.epam.jwd.service;

import com.epam.jwd.model.Shape;
import org.apache.logging.log4j.*;

public abstract class ShapeService<E extends Shape> {
    private static final Logger LOGGER = LogManager.getLogger();

    public void printArr(E[] shapes) {
        for (E shape : shapes) {
            if (isValid(shape)) {
                LOGGER.info(shape);
            } else {
                LOGGER.error("{} - can't exist", shape);
            }
        }
    }
    
    abstract boolean isValid(E shape);

}
