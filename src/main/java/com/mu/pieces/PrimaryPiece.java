package com.mu.pieces;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;

import java.util.Set;

public class PrimaryPiece extends Piece {
    public PrimaryPiece(Board board, Coordinate location) {
        super(board, location);
    }

    @Override
    public Set<Coordinate> getValidMoves() {
        var characteristics=getBoard().getCharacteristics().getWhite();
        return super.getValidMoves(characteristics.getDistance(), characteristics.canJump());
    }
}
