package com.mu.game.characteristics;

import com.mu.game.piece.Coordinate;

import java.util.List;

public class CaptureBehaviour {
    public static final ICapture TWO_WAY_CAPTURE=(piece, neighbours, numberOfOutOfBoundsNeighbours)->{
        if(neighbours.size()<2) return false;
        if(neighbours.keySet().containsAll(List.of(Coordinate.NORTH, Coordinate.SOUTH))) return true;
        if(neighbours.keySet().containsAll(List.of(Coordinate.EAST, Coordinate.WEST))) return true;
        return numberOfOutOfBoundsNeighbours==2;
    };
    public static final ICapture FOUR_WAY_CAPTURE=(piece, neighbours, numberOfOutOfBoundsNeighbours)->{
        return neighbours.size() + numberOfOutOfBoundsNeighbours >= 4;
    };
}
