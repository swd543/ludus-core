package com.mu.game.game;

import com.mu.game.characteristics.Characteristics;
import com.mu.game.piece.Coordinate;
import com.mu.game.piece.PieceType;
import com.mu.game.piece.Pieces;
import com.mu.game.util.Pair;

import java.util.Map;
import java.util.Set;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

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

    /**
     * Get the neighbours of a piece
     * @param from the coordinate relative to which the neighbours are returned
     * @return <neighbours, number of access exceptions>
     */
    Pair<Map<Coordinate, PieceType>, Integer> getNeighbours(Coordinate from);

    /**
     * @param from the coordinate relative to which the neighbours are returned
     * @param filter the filter function, accepting (currentCoordinate, newCoordinate)->logic
     * @param absoluteCoordinate the direction function, accepting (direction)->logic
     * @return <neighbours, number of access exceptions>
     */
    Pair<Map<Coordinate, PieceType>, Integer> getNeighbours(Coordinate from, BiPredicate<PieceType, PieceType> filter, boolean absoluteCoordinate);

    /**
     * Get the neighbours of a piece
     * @param from the coordinate relative to which the neighbours are returned
     * @param absoluteCoordinate the direction function, accepting (direction)->logic
     * @return <neighbours, number of access exceptions>
     */
    Pair<Map<Coordinate, PieceType>, Integer> getNeighbours(Coordinate from, boolean absoluteCoordinate);

    /**
     * Get the neighbours based upon a filter logic
     * @param from the coordinate relative to which the neighbours are returned
     * @param filter the filter function, accepting (currentCoordinate, newCoordinate)->logic
     * @return <neighbours, number of access exceptions>
     */
    Pair<Map<Coordinate, PieceType>, Integer> getNeighbours(Coordinate from, BiPredicate<PieceType, PieceType> filter);

    /**
     * Get the neighbours based upon a filter logic and direction
     * @param from the coordinate relative to which the neighbours are returned
     * @param filter the filter function, accepting (currentCoordinate, newCoordinate)->logic
     * @param direction the direction function, accepting (direction)->logic
     * @return <neighbours, number of access exceptions>
     */
    Pair<Map<Coordinate, PieceType>, Integer> getNeighbours(Coordinate from, BiPredicate<PieceType, PieceType> filter, Predicate<Coordinate> direction);

    /**
     * @param from the coordinate relative to which the neighbours are returned
     * @param filter the filter function, accepting (currentCoordinate, newCoordinate)->logic
     * @param direction the direction function, accepting (direction)->logic
     * @param absoluteCoordinate return position relative to from (false) or absolute position
     * @return  <neighbours, number of access exceptions>
     */
    Pair<Map<Coordinate, PieceType>, Integer> getNeighbours(Coordinate from, BiPredicate<PieceType, PieceType> filter, Predicate<Coordinate> direction, boolean absoluteCoordinate);
}
