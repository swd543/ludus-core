package com.mu.game.game;

import com.mu.game.characteristics.Characteristics;
import com.mu.game.piece.Coordinate;
import com.mu.game.piece.PieceType;
import com.mu.game.piece.Pieces;

import java.util.Set;

public interface IBoard {

    /**
     * Get the bitlong for a particular type of piece
     * @return bitlong for the piece
     */
    Pieces getPieces(PieceType pieceType);

    /**
     * Get the piece at a location
     * @param location
     * @return the piece type
     */
    PieceType getPieceAt(Coordinate location);

    /**
     * Move a piece from a coordinate to another coordinate
     * @param to
     * @param from
     * @return whether piece was moved successfully
     */
    boolean move(Coordinate to, Coordinate from);

    /**
     * Add or remove a piece from the location
     * @param coordinate
     * @param pieceType
     * @param set
     * @return whether piece was updated successfully
     */
    boolean set(Coordinate coordinate, PieceType pieceType, boolean set);

    /**
     * Get all valid moves from a particular location
     * @param from
     * @return
     */
    Set<Coordinate> getValidMoves(Coordinate from);

    /**
     * Reset the board to the initial state
     */
    void reset();


    /**
     * Get the characteristics this board adheres to
     * @return characteristics
     */
    Characteristics getCharacteristics();
}
