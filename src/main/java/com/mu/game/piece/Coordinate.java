package com.mu.game.piece;

import com.mu.game.characteristics.Characteristics;
import com.mu.game.game.Board;

import java.util.Objects;
import java.util.Random;

public class Coordinate {
    public static final Coordinate NORTH=new Coordinate(0,-1);
    public static final Coordinate SOUTH=new Coordinate(0,1);
    public static final Coordinate EAST=new Coordinate(-1,0);
    public static final Coordinate WEST=new Coordinate(1,0);
    public static final Coordinate[] DIRECTIONS=new Coordinate[]{ EAST, WEST, NORTH, SOUTH };
    private int x,y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public Coordinate setX(int x) {
        this.x = x;
        return this;
    }

    public int getY() {
        return y;
    }

    public Coordinate setY(int y) {
        this.y = y;
        return this;
    }

    public int collapse(int numberOfRows){
        return x*numberOfRows+y; }
    public Coordinate add(Coordinate b){ return new Coordinate(b.x+this.x, b.y+this.y); }
    public Coordinate multiply(int distance){ return new Coordinate(this.x*distance, this.y*distance); }
    public Coordinate minus(Coordinate b){ return new Coordinate(this.x-b.x, this.y-b.y); }
    public Coordinate minus(){ return new Coordinate(-this.x, -this.y); }
    public boolean hasNegativeIndices(){ return Math.min(this.x, this.y)<0; }
    public boolean isValidIndex(Board board){ return !hasNegativeIndices() && this.x<board.getCharacteristics().getWidth() && this.y<board.getCharacteristics().getHeight(); };
    public static Coordinate random(Characteristics characteristics){
        var random=new Random();
        return new Coordinate(random.nextInt(characteristics.getWidth()), random.nextInt(characteristics.getHeight()));
    }

    @Override
    public String toString() {
        return String.format("<%-1s,%-1s>",x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }
}
