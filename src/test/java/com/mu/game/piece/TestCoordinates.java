package com.mu.game.piece;

import com.mu.game.characteristics.Characteristics;
import com.mu.game.game.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class TestCoordinates {
    @Test
    public void testAccess() throws CloneNotSupportedException {
        var height=100;
        var width=80;
        var characteristics=new Characteristics(height, width);
        var board=new Board(characteristics);
        var previous=board.getBlacks().clone();
        previous.setNthBit(9,true);

        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                board.getBlacks().setNthBit(new Coordinate(i,j).collapse(height), true);
                Assertions.assertFalse(Arrays.equals(board.getBlacks().getLocations(), previous.getLocations()));
                previous=board.getBlacks().clone();
            }
        }
    }
}
