package com.mu.impl;

import java.util.Objects;

public class Coordinate implements Cloneable{
    private int x,y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    public Coordinate add(Coordinate b){
        this.x+=b.x;
        this.y+=b.y;
        return this;
    }

    public Coordinate multiply(int steps){
        this.x*=steps;
        this.y*=steps;
        return this;
    }

    public static <T> void assign(T[][] array, T element, Coordinate location){ array[location.getX()][location.getY()]=element; }

    public static <T> void clear(T[][] array, Coordinate location){ assign(array, null, location); }

    public static <T> T get(T[][] array, Coordinate location){
        return array[location.getX()][location.getY()];
    }

    @Override
    public Coordinate clone() {
        return new Coordinate(x,y);
    }

    @Override
    public String toString() {
        return "(" +
                "x=" + x +
                ", y=" + y +
                ')';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x &&
                y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
