package com.mu.pieces;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;

/**
 * The Black piece
 */
public class Black extends PrimaryPiece {
    public Black(Board board, Coordinate location) {
        super(board, location);
    }

    private Players signature=Players.Black;
}
