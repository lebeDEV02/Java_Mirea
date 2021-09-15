package com.company;

public class Square extends Rectangle {

    public Square(double width, double length) {
        super(width, length);
    }

    public Square(String color, Boolean filled, double width, double length) {
        super(color, filled, width, length);
    }

    public Square() { }

    public double getSide(){
        return width;
    }

    public void setSide(double side){
        this.width = side;
        this.length = side;
    }

    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    @Override
    public void setLength(double length){
        setSide(length);
    }

    @Override
    public String toString(){
        return " This is square with side = " + getSide();
    }

}
