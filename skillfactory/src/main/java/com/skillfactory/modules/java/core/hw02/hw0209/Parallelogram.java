package com.skillfactory.modules.java.core.hw02.hw0209;

public class Parallelogram extends Quadrangle implements Figure {
     double alpha;
     double beta;

    public Parallelogram(int a, int b, double alfa, double beta, String color) {
        super(a, b, color);
        this.alpha = alfa;
        this.beta = beta;
    }

    @Override
    public double area() {
        return Math.max(a, b) * getHeight();
    }

    @Override
    public double perimeter() {
        return 2 * a + 2 * b;
    }

    @Override
    public double getLargeDiagonal() {
        double d1 = Math.sqrt(a * a + b * b - 2 * b * a * Math.cos(Math.toRadians(beta)));
        double d2 = Math.sqrt(a * a + b * b + 2 * b * a * Math.cos(Math.toRadians(alpha)));
        return Math.max(d1, d2);
    }

    @Override
    public double getHeight() {
        return Math.min(a * Math.sin(Math.toRadians(alpha)), b * Math.sin(Math.toRadians(beta)));
    }

    @Override
    public String getColor() {
        return color;
    }
}
