package com.kodilla.testing.shape;
import java.util.ArrayList;

public class ShapeCollector {

    private final ArrayList<Shape> collectedShapes = new ArrayList<>();

    public void addFigure(Shape shape) {
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
        StringBuilder result = new StringBuilder();
        for (Shape shape : collectedShapes) {
            result.append(shape.getShapeName()).append(" ");
        }
        if (result.length() > 2) {
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }
}



