package com.mu.game.characteristics;

import com.mu.game.piece.Coordinate;
import com.mu.game.piece.PieceType;

import java.util.Map;

public interface ICapture{
    /**
     * @param p the piece type in consideration
     * @param oppositeNeighbours a map of the <Coordinate, PieceType> of the opponent pieces WRT p
     * @param numberOfOutOfBoundsNeighbours the number of 'out of bound' neighbours = 2 for corner piece, 1 for side piece, 0 for middle piece
     * @return whether the piece is captured
     */
    boolean isCaptured(PieceType p, Map<Coordinate, PieceType> oppositeNeighbours, int numberOfOutOfBoundsNeighbours);
}
