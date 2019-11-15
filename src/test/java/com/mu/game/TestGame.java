package com.mu.game;

import com.mu.impl.Board;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class TestGame {
    @Test
    public void testGame(){
        Assertions.assertEquals(1,1,"It works!");
    }

    @Test
    public void testInit(){
        var game=new Board(8,8);
        System.out.println(game);
    }
}
