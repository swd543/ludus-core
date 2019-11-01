package com.mu.impl;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

/**
 * This is the class that will house our board state logic.
 */
public class Board implements PossibleMoves, Moves{

    public Board(){
        // insert constructor here
    }

    @Override
    public List<?> getPossibleMoves() {
        throw new NotImplementedException();
    }

    @Override
    public void move(Coordinate to, Coordinate from) {
        throw new NotImplementedException();
    }
}
