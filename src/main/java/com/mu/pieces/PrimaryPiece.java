package com.mu.pieces;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PrimaryPiece extends Piece {
    public PrimaryPiece(Board board, Coordinate location) {
        super(board, location);
    }

    // Moves possible is any number in the vertical or any number in the horizontal
    @Override
    public Set<Coordinate> getValidMoves() {
        var characteristics=getBoard().getCharacteristics().getWhite();
        return super.getValidMoves(characteristics.getDistance(), characteristics.canJump());
    }
}
