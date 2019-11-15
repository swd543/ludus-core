package com.mu.game;

import com.mu.impl.Board;

/**
 * This is the main class we will use to create the CLI (for now, to test the core until it stabilizes
 */
public class Game {
    public static void main(String[] args) {
        Board game=new Board(8,8);
        System.out.println(game);
    }
}
