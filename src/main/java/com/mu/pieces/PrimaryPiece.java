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

    public Set<Coordinate> getValidMoves(){
        return Set.of(Directions.ALL);
    }

    public List<Coordinate> getValidMoves(Coordinate from){
        List<Coordinate> moves=new ArrayList<>();
        for(var d:Directions.ALL){
//            moves.add();
        }
        return moves;
    }
}
