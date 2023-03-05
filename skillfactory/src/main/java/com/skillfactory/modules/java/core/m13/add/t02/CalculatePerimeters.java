package com.skillfactory.modules.java.core.m13.add.t02;

public class CalculatePerimeters {

    public static void main(String[] args) {

        int sideLengthTriangle = 3;
        int sideLengthSquare = 4;
        int radius = 5;

        System.out.println("Perimetr triangle = " + createCalculator("Triangle", sideLengthTriangle).calculate());
        System.out.println("Perimetr square = " + createCalculator("Square", sideLengthSquare).calculate());
        System.out.println("Perimetr circle = " + createCalculator("Circle", radius).calculate());
    }

    private interface CalculatorPerimeter {
        double calculate();
    }

    private static CalculatorPerimeter createCalculator(String type, int value) {
        if (type.equals("Triangle")) {
            return new TriangleCalculatorPerimeter(value);
        } else if (type.equals("Square")) {
            return new SquareCalculatorPerimeter(value);
        } else if (type.equals("Circle")) {
            return new CircleCalculatorPerimeter(value);
        } else {
            return new NullableCalculatorPerimeter();
        }
    }

    private static class NullableCalculatorPerimeter implements CalculatorPerimeter {
        @Override
        public double calculate() {
           return 0;
        }
    }

    private static class TriangleCalculatorPerimeter implements CalculatorPerimeter {
        final private double length;

        public TriangleCalculatorPerimeter(double length) {
            this.length = length;
        }

        @Override
        public double calculate() {
            return 3 * length;
        }
    }

    private static class SquareCalculatorPerimeter implements CalculatorPerimeter {

        final private double length;

        public SquareCalculatorPerimeter(double length) {
            this.length = length;
        }

        @Override
        public double calculate() {
            return 4 * length;
        }

    }

    private static class CircleCalculatorPerimeter implements CalculatorPerimeter {

        final private double radius;

        public CircleCalculatorPerimeter(double radius) {
            this.radius = radius;
        }

        @Override
        public double calculate() {
            double PI = 3.14159;
            return 2 * PI * radius;
        }
    }
}
