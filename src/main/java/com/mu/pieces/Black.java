package com.mu.pieces;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;

import java.util.Set;

/**
 * The Black piece
 */
public class Black extends PrimaryPiece {
    public Black(Board board, Coordinate location) {
        super(board, location);
    }

    private Players signature=Players.Black;

    @Override
    public Set<Coordinate> getValidMoves() {
        var characteristics=getBoard().getCharacteristics().getBlack();
        return super.getValidMoves(characteristics.getDistance(), characteristics.canJump());    }
}
