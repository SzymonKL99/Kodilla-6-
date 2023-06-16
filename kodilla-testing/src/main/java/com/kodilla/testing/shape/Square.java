package com.kodilla.testing.shape;

import java.util.Objects;


import com.kodilla.testing.shape.Shape;

import java.util.Objects;
class Square implements Shape {
        private String shapeName;
        private int field;

        public Square(String shapeName, int field) {
            this.shapeName = shapeName;
            this.field = field;

        }

        @Override
        public String toString() {
            return "Square{" +
                    "shapeName='" + shapeName + '\'' +
                    ", field=" + field +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Square square = (Square) o;
            return field == square.field && Objects.equals(shapeName, square.shapeName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(shapeName, field);
        }

        @Override
        public String getShapeName() {
            return shapeName;
        }

        @Override
        public int getField() {
            return field;
        }
    }


