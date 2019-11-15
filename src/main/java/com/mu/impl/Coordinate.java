package com.mu.impl;

public class Coordinate implements Cloneable{
    private int x,y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate add(Coordinate b){
        this.x+=b.x;
        this.y+=b.y;
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
