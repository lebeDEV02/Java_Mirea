package com.company;

public class MovableCircle implements Movable {

    private int radius;
    private MovablePoint center;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        this.radius = radius;
        this.center = new MovablePoint(x, y, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        this.center.x += this.center.xSpeed;
    }

    @Override
    public void moveDown() {
        this.center.x -= this.center.xSpeed;

    }

    @Override
    public void moveLeft() {
        this.center.y -= this.center.ySpeed;

    }

    @Override
    public void moveRight() {
        this.center.y += this.center.ySpeed;

    }

    @Override
    public String toString() {
        return "MovableCircle{" +
                "radius=" + radius +
                ", center=" + center +
                '}';
    }
}