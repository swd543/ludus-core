package com.mu.game;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;
import com.mu.pieces.*;
import org.junit.jupiter.api.*;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class TestGame {
    private int width=8;
    private int height=8;
    private Board game=new Board(width,height);

    @Test
    public void testInitialize(){
        game=new Board(7,8);
        Assertions.assertEquals(game.getField().length,7);
        Assertions.assertEquals(game.getField()[0].length,8);
        Assertions.assertEquals(game.getWidth(),7);
        Assertions.assertEquals(game.getHeight(),8);
    }

    @Test
    public void testReinitializeWithPieces(){
        game=new Board(width,height);
        List<Piece> pieces=List.of(
                new White(game, new Coordinate(0,0)),
                new Black(game, new Coordinate(width-1,height-1))
        );
        game.setPieces(pieces);
        Assertions.assertTrue(game.getField()[0][0] instanceof White);
        Assertions.assertTrue(game.getField()[width-1][height-1] instanceof Black);
    }

    @Test
    public void testMove(){
        game=new Board(width,height);
        final var init=new Coordinate(width/2, height/2);
        final var fin=init.clone().add(Directions.SOUTH);
        List<Piece> pieces=List.of(
                new Dux(game, init)
        );
        game.setPieces(pieces);
        game.getPieces().get(0).move(fin);
        Assertions.assertNull(Coordinate.get(game.getField(), init), "Test if previous location nullified");
        Assertions.assertTrue(game.getField()[width/2+Directions.SOUTH.getX()][height/2+Directions.SOUTH.getY()] instanceof Dux);
    }
}
