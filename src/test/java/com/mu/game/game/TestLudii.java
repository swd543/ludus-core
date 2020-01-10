package com.mu.game.game;

import com.mu.game.characteristics.CaptureBehaviour;
import com.mu.game.characteristics.Characteristics;
import com.mu.game.piece.Coordinate;
import com.mu.game.piece.PieceType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestLudii {
    private Characteristics characteristics= Common.testCharacteristics;

    @Test
    public void testIsPieceCaptured2WayMid() {
        var board=new Board(characteristics);
        var game=new Ludii(board);
        var a=new Coordinate(2,2);
        game.addPiece(a);
        game.addPiece(a.add(Coordinate.NORTH));
        game.addPiece(new Coordinate(7,7));
        game.addPiece(a.add(Coordinate.SOUTH));
        Assertions.assertTrue(game.isPieceCaptured(a, CaptureBehaviour.TWO_WAY_CAPTURE),"Two way capture for top-down");
        Assertions.assertFalse(game.isPieceCaptured(a, CaptureBehaviour.FOUR_WAY_CAPTURE), "Four way capture for top-down");
    }

    @Test
    public void testIsPieceCaptured2WayCorner() {
        var board=new Board(characteristics);
        var game=new Ludii(board);
        var a=new Coordinate(0,0);
        game.addPiece(a);
        game.addPiece(a.add(Coordinate.SOUTH));
        game.addPiece(new Coordinate(7,7));
        Assertions.assertFalse(game.isPieceCaptured(a, CaptureBehaviour.TWO_WAY_CAPTURE), "Two way capture for bottom in corner");
        Assertions.assertFalse(game.isPieceCaptured(a, CaptureBehaviour.FOUR_WAY_CAPTURE), "Four way capture for bottom in corner");
        game.addPiece(a.add(Coordinate.WEST));
        Assertions.assertTrue(game.isPieceCaptured(a, CaptureBehaviour.TWO_WAY_CAPTURE), "Two way capture for bottom-right in corner");
        Assertions.assertTrue(game.isPieceCaptured(a, CaptureBehaviour.FOUR_WAY_CAPTURE), "Four way capture for bottom-right in corner");
    }

    @Test
    public void testIsPieceCaptured2WaySide() {
        var board=new Board(characteristics);
        var game=new Ludii(board);
        var a=new Coordinate(0,1);
        game.addPiece(a);
        game.addPiece(a.add(Coordinate.SOUTH));
        Assertions.assertFalse(game.isPieceCaptured(a, CaptureBehaviour.TWO_WAY_CAPTURE), "Two way capture for bottom in side");
        Assertions.assertFalse(game.isPieceCaptured(a, CaptureBehaviour.FOUR_WAY_CAPTURE), "Four way capture for bottom in side");
        game.addPiece(new Coordinate(7,7));
        game.addPiece(a.add(Coordinate.WEST));
        Assertions.assertFalse(game.isPieceCaptured(a, CaptureBehaviour.TWO_WAY_CAPTURE), "Two way capture for bottom-right in side");
        Assertions.assertFalse(game.isPieceCaptured(a, CaptureBehaviour.FOUR_WAY_CAPTURE), "Four way capture for bottom-right in side");
        game.addPiece(new Coordinate(6,6));
        game.addPiece(a.add(Coordinate.NORTH));
        Assertions.assertTrue(game.isPieceCaptured(a, CaptureBehaviour.TWO_WAY_CAPTURE), "Two way capture for bottom-right-top in side");
        Assertions.assertTrue(game.isPieceCaptured(a, CaptureBehaviour.FOUR_WAY_CAPTURE), "Four way capture for bottom-right-top in side");
    }

    @Test
    public void testIsPieceCaptured4WayMid() {
        var board=new Board(characteristics);
        var game=new Ludii(board);
        var a=new Coordinate(2,2);
        board.set(a, PieceType.WHITE, true);
        for(var d:Coordinate.DIRECTIONS){ board.set(d.add(a), PieceType.BLACK, true); }
        Assertions.assertTrue(game.isPieceCaptured(a, CaptureBehaviour.TWO_WAY_CAPTURE),"Two way capture in mid");
        Assertions.assertTrue(game.isPieceCaptured(a, CaptureBehaviour.FOUR_WAY_CAPTURE), "Four way capture in mid");
    }
}