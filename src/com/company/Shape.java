package com.company;

public abstract class Shape {
    protected String color;
    protected Boolean filled;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean isFilled() {
        return filled;
    }

    public void setFilled(Boolean filled) {
        this.filled = filled;
    }

    public Shape(String color, Boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public Shape() {
        this.color = "BLACK";
        this.filled = false;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public abstract String toString();
}