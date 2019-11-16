package com.mu.game;

import com.mu.impl.Board;
import com.mu.impl.Coordinate;
import com.mu.pieces.Black;
import com.mu.pieces.Directions;
import com.mu.pieces.Piece;
import com.mu.pieces.White;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.List;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
public class TestGame {
    private int width=8;
    private int height=8;
    private Board game=new Board(width,height);

    @Test
    public void testA_Initialize(){
        game=new Board(7,8);
        Assertions.assertEquals(game.getField().length,7);
        Assertions.assertEquals(game.getField()[0].length,8);
        Assertions.assertEquals(game.getWidth(),7);
        Assertions.assertEquals(game.getHeight(),8);
    }

    @Test
    public void testB_ReinitializeWithPieces(){
        game=new Board(width,height);
        System.out.println(game);
        List<Piece> pieces=List.of(
                new White(game, new Coordinate(0,0)),
                new Black(game, new Coordinate(width-1,height-1))
        );
        game.setPieces(pieces);
        Assertions.assertEquals(game.toString(),"Board{width=8, height=8, moveCounter=0, ruleSet='null', playerTurn=White, history=null, field=\n" +
                "W _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ _ \n" +
                "_ _ _ _ _ _ _ B \n" +
                "}");
    }
}
