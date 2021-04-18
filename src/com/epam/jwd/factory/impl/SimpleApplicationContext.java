package com.epam.jwd.factory.impl;

import com.epam.jwd.decorator.impl.PostProcessingShapeFactory;
import com.epam.jwd.decorator.impl.PreProcessingShapeFactory;
import com.epam.jwd.factory.api.ApplicationContext;
import com.epam.jwd.factory.api.ShapeFactory;
import com.epam.jwd.model.polygonal.PolygonalShapeFactory;

public class SimpleApplicationContext implements ApplicationContext {

    private static SimpleApplicationContext instance;

    private SimpleApplicationContext() {
    }

    public static SimpleApplicationContext getInstance() {
        if (instance == null) {
            instance = new SimpleApplicationContext();
        }
        return instance;
    }

    @Override
    public ShapeFactory createShapeFactory() {
        PolygonalShapeFactory shapeFactory = PolygonalShapeFactory.getInstance();
        PreProcessingShapeFactory preProcessingShapeFactory = new PreProcessingShapeFactory(shapeFactory);
        return new PostProcessingShapeFactory(preProcessingShapeFactory);
    }

}
