package com.mu.pieces;

import com.mu.impl.Coordinate;

public class Directions {
//    static final Coordinate NORTHEAST=new Coordinate(-1,-1);
//    static final Coordinate NORTHWEST=new Coordinate(-1,1);
    public static final Coordinate EAST=new Coordinate(-1,0);
    public static final Coordinate WEST=new Coordinate(1,0);
    public static final Coordinate NORTH=new Coordinate(0,-1);
    public static final Coordinate SOUTH=new Coordinate(0,1);
    public static final Coordinate[] ALL={EAST,WEST,NORTH,SOUTH};
}
