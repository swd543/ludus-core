package com.mu.pieces;

import com.mu.impl.Coordinate;

import java.util.ArrayList;
import java.util.List;

public class Primary extends Piece {
    public List<Coordinate> getValidMoves(){
        return List.of(Directions.ALL);
    }

    public List<Coordinate> getValidMoves(Coordinate from){
        List<Coordinate> moves=new ArrayList<>();
        for(var d:Directions.ALL){
//            moves.add();
        }
        return moves;
    }
}
