package com.epam.jwd.builder;

import com.epam.jwd.constant.ShapeType;

public class PolygonalShapeCriteria {
    private final int shapeId;
    private final ShapeType shapeType;
    private final double shapeArea;
    private final double shapePerimeter;

    private PolygonalShapeCriteria(int shapeId, double shapeArea, double shapePerimeter, ShapeType shapeType) {
        this.shapeId = shapeId;
        this.shapeArea = shapeArea;
        this.shapePerimeter = shapePerimeter;
        this.shapeType = shapeType;
    }

    public double getShapeArea() {
        return shapeArea;
    }

    public double getShapePerimeter() {
        return shapePerimeter;
    }

    public int getShapeId() {
        return shapeId;
    }

    public ShapeType getShapeType() {
        return shapeType;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private int shapeId = -1;
        private ShapeType shapeType;
        private double shapeArea = -1;
        private double shapePerimeter = -1;


        public Builder shapesWithId(int figureId) {
            this.shapeId = figureId;
            return this;
        }

        public Builder shapesWithType(ShapeType figureType) {
            this.shapeType = figureType;
            return this;
        }

        public Builder shapesWithPerimeter(double figurePerimeter) {
            this.shapePerimeter = figurePerimeter;
            return this;
        }

        public Builder shapesWithArea(double figureArea) {
            this.shapeArea = figureArea;
            return this;
        }

        public PolygonalShapeCriteria build() {
            return new PolygonalShapeCriteria(this.shapeId, this.shapeArea, this.shapePerimeter, this.shapeType);
        }
    }
}
