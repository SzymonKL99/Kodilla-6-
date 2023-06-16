package com.kodilla.testing.shape;
import com.kodilla.testing.shape.ShapeCollector;
import java.util.ArrayList;

public class ShapeCollector {
    private String nameOfFigure;

    public ShapeCollector(String nameOfFigure) {
        this.nameOfFigure = nameOfFigure;
    }

    private ArrayList<Shape> collectedShapes = new ArrayList<Shape>();

    public void addFigure(Shape shape) {
        ShapeCollector shapeCollector = new ShapeCollector(nameOfFigure);
        collectedShapes.add(shape);
    }

    public boolean removeFigure(Shape shape) {
        boolean result = false;
        if (collectedShapes.contains(shape)) {
            collectedShapes.remove(shape);
            result = true;
        }
        return result;
    }

    public Circle getFigure(int n) {
        if (n >= 0 && n < collectedShapes.size()) {
            return (Circle) collectedShapes.get(n);
        }
        return null;
    }
    public String showFigures() {
        return String.valueOf(collectedShapes.size());
    }
    public String getNameOfFigure() {
        return nameOfFigure;
    }
}


