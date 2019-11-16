package com.mu.game;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;
import com.mu.pieces.Black;
import com.mu.pieces.Directions;
import com.mu.pieces.Piece;
import com.mu.pieces.White;

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
                new Black(game, new Coordinate(4,4))
        );
        game.setPieces(pieces);
        System.out.println(game);
        game.getPieces().get(0).move(Directions.SOUTH);
        System.out.println(game);
    }
}
