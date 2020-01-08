package com.mu.game.piece;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestPieces {
    @Test
    public void testClone() throws CloneNotSupportedException {
        var x=new Pieces(256);
        var y=x.clone();
        Assertions.assertArrayEquals(x.getLocations(), y.getLocations());
        x.setNthBit(1,true);
        Assertions.assertFalse(Arrays.equals(x.getLocations(), y.getLocations()));
    }

    @Test
    public void testPieces() throws CloneNotSupportedException {
        var n=new Pieces(256);
        var p=n.clone();
        p.setNthBit(1,true);
        for(var i=0;i<256;i++){
            n.setNthBit(i, true);
            Assertions.assertFalse(Arrays.equals(n.getLocations(), p.getLocations()));
            p=n.clone();
        }
        for(var i=0;i<256;i++){
            n.setNthBit(i, false);
            Assertions.assertFalse(Arrays.equals(n.getLocations(), p.getLocations()));
            p=n.clone();
        }
    }

    @Test
    public void testGetBit() throws CloneNotSupportedException {
        var n=new Pieces(256);
        for(var i=0;i<256;i++){
            n.setNthBit(i, true);
            Assertions.assertTrue(n.getNthBit(i));
        }
        for(var i=0;i<256;i++){
            n.setNthBit(i, false);
            Assertions.assertFalse(n.getNthBit(i));
        }
    }
}
