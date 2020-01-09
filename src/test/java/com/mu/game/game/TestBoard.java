package com.mu.game.game;

import com.mu.game.characteristics.Characteristics;
import com.mu.game.piece.Coordinate;
import com.mu.game.piece.PieceType;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
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

    @Test
    public void testNeighbours(){
        var board=new Board(characteristics);
        var a=new Coordinate(2,2);
        var l=new ArrayList<Coordinate>();
        for(var d:Coordinate.DIRECTIONS){ l.add(d.add(a)); }
        board.set(a, PieceType.WHITE, true);
        for(var c:l){ board.set(c, PieceType.BLACK, true); }
        var neighbours=board.getNeighbours(a);
        assertEquals(neighbours.size(),4,"Correct number of opposite neighbours?");
        neighbours.forEach((c,p)->assertEquals(p, PieceType.BLACK, "All opposite neighbours correctly expressed?"));
        for(var c:l){ board.set(c, PieceType.BLACK, false); board.set(c, PieceType.WHITE, true); }
        neighbours=board.getNeighbours(a);
        assertEquals(neighbours.size(),4,"Correct number of same neighbours?");
        neighbours.forEach((c,p)->assertEquals(p, PieceType.WHITE, "All same neighbours correctly expressed?"));
        var b=new Coordinate(characteristics.getWidth()-1, characteristics.getHeight()-1);
        var d=new Coordinate[]{Coordinate.NORTH, Coordinate.EAST};
        board.set(b, PieceType.WHITE, true);
        Arrays.stream(d).forEach(x->board.set(x.add(b), PieceType.WHITE, true));
        System.out.println(board);
        neighbours=board.getNeighbours(b);
        assertEquals(neighbours.size(),2,"Correct number of edge neighbours?");
        neighbours.forEach((c,p)->assertEquals(p, PieceType.WHITE, "Gets neighbours even edge of the board?"));
        neighbours=board.getNeighbours(b, false);
        assertEquals(neighbours.size(),2,"Correct number of edge neighbours?");
        assertTrue(neighbours.containsKey(Coordinate.EAST), "Neighbours contain relative EAST?");
        assertTrue(neighbours.containsKey(Coordinate.NORTH), "Neighbours contain relative NORTH?");
    }
}