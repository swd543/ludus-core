package com.mu.pieces;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;

public class White extends PrimaryPiece {
    public White(Board board, Coordinate location) {
        super(board, location);
    }

    private Players signature=Players.White;
}
