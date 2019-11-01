package com.mu.impl;

import java.util.List;

/**
 * This is the class that will house our board state logic.
 */
public class Board implements PossibleMoves, Moves, Evaluate{

    public Board(){
        // insert constructor here
    }

    @Override
    public List<?> getPossibleMoves() {
        throw new UnsupportedOperationException("This has not been implemented yet");
    }

    @Override
    public void move(Coordinate to, Coordinate from) {
        throw new UnsupportedOperationException("This has not been implemented yet");
    }

    @Override
    public int evaluate() {
        throw new UnsupportedOperationException("This has not been implemented yet");
    }
}
