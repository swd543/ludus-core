package com.mu.game.display;

import com.mu.game.game.Board;

import javax.swing.*;
import java.awt.*;

public class GameStatsPanel extends JPanel {
    private JLabel toPlay;
    private JCheckBox displayMoves;
    public GameStatsPanel(final Board board, final GameFrame frame) throws HeadlessException {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setVisible(true);
    }

    public JCheckBox getDisplayMoves() { return displayMoves; }
}
