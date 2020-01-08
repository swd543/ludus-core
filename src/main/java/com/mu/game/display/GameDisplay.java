package com.mu.game.display;

import com.mu.game.game.Ludii;

import javax.swing.*;
import java.awt.*;

public class GameDisplay extends JFrame {
    public GameDisplay(final Ludii board) {
        setLayout(new GridBagLayout());
        var gameFrame=new GameFrame(board);
//        var gameStatsPanel=new GameStatsPanel(board, gameFrame);
//        add(gameStatsPanel);
//        gameFrame.setGameStatsPanel(gameStatsPanel);
        add(gameFrame);
        setSize(800,600);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
