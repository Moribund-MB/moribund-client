package com.github.moribund.entity;

public interface Movable {
    float getX();
    float getY();
    void setX(float x);
    void setY(float y);
    void setRotation(float angle);
    float getRotation();
    void rotateLeft();
    void rotateRight();
    void moveForward();
    void moveBack();
}
