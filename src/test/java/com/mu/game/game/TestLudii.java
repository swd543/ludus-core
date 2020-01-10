package com.mu.game.game;

import com.mu.game.characteristics.Characteristics;
import com.mu.game.piece.Coordinate;
import com.mu.game.piece.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLudii {
    private Characteristics characteristics= Common.testCharacteristics;

    @Test
    public void testIsPieceCaptured2Way() {
        var board=new Board(characteristics);
        var game=new Ludii(board);
        var a=new Coordinate(2,2);
        game.addPiece(a);
        game.addPiece(a.add(Coordinate.NORTH));
        game.addPiece(new Coordinate(7,7));
        game.addPiece(a.add(Coordinate.SOUTH));
        Assertions.assertTrue(game.isPieceCaptured(a));
        System.out.println(board);
    }

    @Test
    public void testIsPieceCaptured4Way() {
        var board=new Board(characteristics);
        var game=new Ludii(board);
        var a=new Coordinate(2,2);
        game.addPiece(a);
        game.addPiece(a.add(Coordinate.NORTH));
        game.addPiece(new Coordinate(7,7));
        game.addPiece(a.add(Coordinate.SOUTH));
        Assertions.assertTrue(game.isPieceCaptured(a));
    }
}