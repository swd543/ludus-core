package com.mu.game.display;

import com.mu.game.game.Ludii;
import com.mu.game.piece.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

public class GameFrame extends JPanel {
    private final Ludii game;
    private final JButton[][] buttonMap;
    private GameStatsPanel gameStatsPanel;
    private JLabel messageArea;

    public GameFrame(final Ludii game){
        this(game, null);
    }

    public GameStatsPanel getGameStatsPanel() { return gameStatsPanel; }

    public GameFrame setGameStatsPanel(GameStatsPanel gameStatsPanel) {
        this.gameStatsPanel = gameStatsPanel;
        return this;
    }

    public GameFrame(final Ludii game, GameStatsPanel gameStatsPanel) throws HeadlessException {
        this.game = game;
        var mf=85;
        var width= game.getBoard().getCharacteristics().getWidth();
        var height= game.getBoard().getCharacteristics().getHeight();
        this.buttonMap =new JButton[height][width];

        var gameArea=new JPanel();
        var statsArea=new JPanel();

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        setup(gameArea, area->{
            area.setPreferredSize(new Dimension(width*mf, height*mf));
            area.setLayout(new GridLayout(height,width));
            area.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            for(var i = 0; i< height; i++){
                for(var j = 0; j< width; j++){
                    var c= new Coordinate(j,i);
                    var p= game.getBoard().getPieceAt(c);
                    JButton button=new JButton(c.toString());
                    button.addActionListener(action->{
                        game.addPiece(c);
                        var piece= game.getBoard().getPieceAt(c);
                        button.setBackground(piece.getColor());
                        button.repaint();
                    });
                    button.addFocusListener(new FocusListener() {
                        private Set<Coordinate> moves=new HashSet<>();
                        @Override
                        public void focusGained(FocusEvent focusEvent) {
                            moves= game.getBoard().getValidMoves(c);
                            for(var t:moves){
                                buttonMap[t.getY()][t.getX()].setBorder(BorderFactory.createLineBorder(Color.YELLOW));
                            }
                        }

                        @Override
                        public void focusLost(FocusEvent focusEvent) {
                            for(var t:moves){
                                buttonMap[t.getY()][t.getX()].setBorder(new JButton().getBorder());
                            }
                        }
                    });
                    try{
                        button.setBackground(p.getColor());
                    } catch (NullPointerException ignored){
                        button.setBackground(Color.GRAY);
                    }
                    finally {
                        area.add(button);
                        buttonMap[c.getY()][c.getX()]=button;
                    }
                }
            }
            area.setVisible(true);
            return null;
        });

        setup(statsArea, area->{
            area.setLayout(new BoxLayout(area, BoxLayout.Y_AXIS));
            messageArea=new JLabel(game.getPlayerToMove()+" to move");
            area.add(messageArea);
            area.add(new JButton("Popp"));
            return null;
        });

        resync();

        add(statsArea);
        add(gameArea);
        setVisible(true);
    }

    private void setup(JPanel panel, Function<JPanel, Void> panelFunction){ panelFunction.apply(panel); }

    public void resync(){
        for(var i = 0; i< game.getBoard().getCharacteristics().getWidth(); i++){
            for(var j = 0; j< game.getBoard().getCharacteristics().getHeight(); j++){
                var c=new Coordinate(i,j);
                var p= game.getBoard().getPieceAt(c);
                var button= buttonMap[j][i];
                try{
                    button.setBackground(p.getColor());
                } catch (NullPointerException ignored){
                    button.setBackground(Color.GRAY);
                }
                finally {
                    button.repaint();
                    messageArea.setText(game.getPlayerToMove().toString()+" to move");
                    messageArea.repaint();
                }
            }
        }
    }
}
