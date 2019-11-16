package com.mu.impl;

public class Coordinate implements Cloneable{
    private int x,y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Coordinate add(Coordinate b){
        this.x+=b.x;
        this.y+=b.y;
        return this;
    }

    public static <T> void assign(T[][] array, T element, Coordinate location){
        array[location.getX()][location.getY()]=element;
    }

    public static <T> void clear(T[][] array, Coordinate location){
        assign(array, null, location);
    }

    public static <T> T get(T[][] array, Coordinate location){
        return array[location.getX()][location.getY()];
    }

    @Override
    public String toString() {
        return "[" +
                "x=" + x +
                ", y=" + y +
                ']';
    }
}
