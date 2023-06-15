package com.kodilla.testing.shape;

import java.util.Objects;

class Circle implements Shape {
    private String shapeName;
    private int field;

    public Circle(String shapeName, int field) {
        this.shapeName = shapeName;
        this.field = field;
    }
    @Override
    public String getShapeName() {
        return shapeName;
    }

    @Override
    public int getField() {
        return field;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "ShapeName='" + shapeName + '\'' +
                ", Field=" + field +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Circle circle = (Circle) o;
        return field == circle.field && Objects.equals(shapeName, circle.shapeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shapeName, field);
    }
}

