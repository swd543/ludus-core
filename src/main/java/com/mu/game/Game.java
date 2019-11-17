package com.mu.game;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;
import com.mu.pieces.*;

import java.util.List;

/**
 * This is the main class we will use to create the CLI (for now, to test the core until it stabilizes
 */
public class Game {
    public static void main(String[] args) {
        var game=new Board(8,8);
        System.out.println(game);
        List<Piece> pieces=List.of(
                new White(game, new Coordinate(0,0)),
                new Black(game, new Coordinate(1,1)),
                new Black(game, new Coordinate(4,4)),
                new Dux(game, new Coordinate(7,7))
        );
        System.out.println(game.getCharacteristics());
        game.setPieces(pieces);
        System.out.println(game);
        game.getPieces().get(0).move(Directions.SOUTH);
        System.out.println(game);
        pieces.forEach(p->{
            System.out.println(p.getLocation()+"->"+p.getValidMoves());
        });
    }
}
