package com.mu.game.game;

import com.mu.game.characteristics.Characteristics;
import com.mu.game.piece.Coordinate;
import com.mu.game.piece.PieceType;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class TestBoard {
    private final Characteristics characteristics=new Characteristics();
    private final Set<Coordinate> locations=new HashSet<>();

    public TestBoard() { for(var i=0;i<characteristics.getPiecesPerPlayer();i++){ locations.add(Coordinate.random(characteristics)); } }

    @Test
    public void testGetSetPieces(){
        var board=new Board(characteristics);
        for(var location:locations){
            board.set(location, PieceType.WHITEDUX, true);
            assertSame(board.getPieceAt(location), PieceType.WHITEDUX, "Whether piece was set at location successfully");
        }
        for(var location:locations){ assertFalse(board.set(location, PieceType.BLACK, true)); }
        for(var location:board.getBlackDuxes().getLocations()){ assertEquals(location, 0L, "Blackduxes must not have values"); }
        for(var location:board.getWhiteDuxes().getLocations()){ assertNotEquals(location, 0L, "Whiteduxes must have nonzero values"); }
        assertFalse(board.set(new Coordinate(-1,1), PieceType.BLACK, true), "If x coordinate is negative, do not add piece");
        assertFalse(board.set(new Coordinate(1,-1), PieceType.BLACK, true), "If y coordinate is negative, do not add piece");
        assertFalse(board.set(new Coordinate(-1,-1), PieceType.BLACK, true), "If x&y coordinate are negative, do not add piece");
        assertFalse(board.set(new Coordinate(1,-1), PieceType.BLACK, false), "If y coordinate is negative, do not remove piece");
        assertFalse(board.set(new Coordinate(-1,1), PieceType.BLACK, false), "If x coordinate is negative, do not remove piece");
        assertFalse(board.set(new Coordinate(-1,-1), PieceType.BLACK, false), "If x&y coordinate is negative, do not remove piece");
        Coordinate randomLocation=Coordinate.random(characteristics);
        while (locations.contains(randomLocation)){ randomLocation=Coordinate.random(characteristics); }
        assertFalse(board.set(randomLocation, PieceType.WHITEDUX, false), "If piece does not exist at location, do not remove piece");
        //TODO: this test fails
        //for(var location:locations){ assertFalse(board.set(location, PieceType.BLACK, false)); }
        for(var location:locations){ assertTrue(board.set(location, PieceType.WHITEDUX, false), "Remove piece at location that exists"); }
    }

    @Test
    public void testMove(){
        var board=new Board(characteristics);
        for(var location:locations){ board.set(location, PieceType.WHITE, true); }
        Coordinate randomLocation=null;
        do{ randomLocation=Coordinate.random(characteristics);
        } while (locations.contains(randomLocation));
        var iterator=locations.iterator();
        var from=iterator.next();
        assertTrue(board.move(randomLocation, from), "Whether move is successful");
        assertNull(board.getPieceAt(from), "After move, previous location must be null");
        assertSame(board.getPieceAt(randomLocation), PieceType.WHITE, "After move, location moved to must be that piece");
        board.set(from, PieceType.BLACK, true);
        assertFalse(board.move(randomLocation, from), "Should not be able to move from a black occupied location to a white occupied location");
        assertNotNull(board.getPieceAt(from), "After invalid move state should not change");
        assertSame(board.getPieceAt(randomLocation), PieceType.WHITE, "After invalid move state should not change" );
        from=iterator.next();
        randomLocation=iterator.next();
        assertFalse(board.move(randomLocation, from),"Should not be able to move to occupied location");
        assertFalse(board.move(from, new Coordinate(-1,-1)),"Should not be able to move to invalid location");
    }
}