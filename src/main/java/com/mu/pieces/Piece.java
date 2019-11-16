package com.mu.pieces;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;

import java.util.*;

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
        if(getValidMoves().contains(location)){
            Coordinate.clear(board.getField(), this.location);
            Coordinate.assign(board.getField(), this, location);
            this.board.getHistory().push(List.of(this.location, location));
            this.location=location;
        } else {
            throw new IllegalArgumentException("Invalid move attempted from "+this.location+" to "+location);
        }
    }

    public Set<Coordinate> getValidMoves(){
        return getValidMoves(Integer.MAX_VALUE);
    }

    Set<Coordinate> getValidMoves(int distance){
        return getValidMoves(distance, false);
    }

    Set<Coordinate> getValidMoves(int distance, boolean jumpAllowed){
        Set<Coordinate> possible=new HashSet<>();
        for(Coordinate d:Directions.ALL){
            for(var i=1;i<=distance;i++){   //TODO: from characteristics
                var delta=d.clone().multiply(i);
                var newCoordinate=location.clone().add(delta);
                if (board.isValidCoordinate(newCoordinate) && board.isFree(newCoordinate))
                    possible.add(newCoordinate);
                else if(jumpAllowed) {

                }
                else
                    break;
            }
        }
        return possible;
    }

    private Set<Coordinate> getValidMovesRecursive(Set<Coordinate> coordinates, Coordinate from){
        if(coordinates.contains(from)){
            return coordinates;
        }
        for(Coordinate d:Directions.ALL){
            for(var i=1;i<=1;i++){   //TODO: What happens if both multiple moves and jumps enabled?
                var delta=d.clone().multiply(i);
                var newCoordinate=from.clone().add(delta);
                if (board.isValidCoordinate(newCoordinate) && board.isFree(newCoordinate)){
                    delta.add(d);
                    coordinates.add(newCoordinate);
                    getValidMovesRecursive(coordinates, newCoordinate);
                }
                else
                    break;
            }
        }
        return coordinates;
    }

    Board getBoard() { return board; }
}
