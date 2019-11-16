package com.mu.pieces;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;

/**
 * The base class for a Piece
 */
public class Piece {
    /**
     * A reference to the board object. Imperative!
     */
    private Board board;

    private Coordinate location;
    public Coordinate getLocation() { return location; }

    public Piece(Board board, Coordinate location) {
        this.board = board;
        this.location=location;
    }

    public void move(Coordinate location){
        // TODO: check if valid move, then move, otherwise throw Exception
        if(true){
            Coordinate.clear(board.getField(), this.location);
            Coordinate.assign(board.getField(), this, location);
//            board.getField()[location.getX()][location.getY()]=this;
            this.location=location;
        } else {
            throw new IllegalArgumentException("Invalid move");
        }
    }
}
