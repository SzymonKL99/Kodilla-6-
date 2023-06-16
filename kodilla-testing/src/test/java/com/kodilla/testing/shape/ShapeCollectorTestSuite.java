package com.kodilla.testing.shape;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class ShapeCollectorTestSuite {
    @Test
    void testAddFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle("circle", 57);

        //When
        shapeCollector.addFigure(circle);

        //Then
        Assertions.assertEquals(circle,shapeCollector.getFigure(0));
    }

    @Test
    void testRemoveFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle("circle", 57);

        //When
        boolean result = shapeCollector.removeFigure(circle);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    void testGetFigure() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();
        Circle circle = new Circle("circle", 57);
        shapeCollector.addFigure(circle);

        //When
        Circle retrivedCircle;
        retrivedCircle = shapeCollector.getFigure(0);

        //Then
        assertEquals(circle,retrivedCircle);
    }

    @Test
    void testShowFigures() {
        //Given
        ShapeCollector shapeCollector = new ShapeCollector();

        Circle circle = new Circle("circle",57);
        Square square = new Square("square", 441);
        Triangle triangle = new Triangle("triangle", 74);

        //When
        shapeCollector.addFigure(triangle);
        shapeCollector.addFigure(circle);
        shapeCollector.addFigure(square);

        //Then
        Assertions.assertEquals("triangle circle square",shapeCollector.showFigures());

    }

}
