package com.mu.game;

import com.mu.game.characteristics.Characteristics;
import com.mu.game.characteristics.Ruleset;
import com.mu.game.display.GameFrame;
import com.mu.game.game.Board;
import com.mu.game.game.Ludii;
import com.mu.game.piece.Coordinate;
import com.mu.game.piece.PieceType;

import javax.swing.*;
import java.awt.*;

public class Game {
    static class Display extends JFrame{
        private Ludii ludus;
        private GameFrame gameFrame;

        public Display(Ludii ludus) throws HeadlessException {
            this.ludus = ludus;
            gameFrame=new GameFrame(ludus);
            add(gameFrame);
            pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
        }

        public void resync(){ gameFrame.resync(); }

        public Ludii getLudus() { return ludus; }
    }

    public static void main(String[] args) throws Exception {
//        var board=new Board(new Characteristics(20,20));
        var board=new Board(Characteristics.getCharacteristics(Ruleset.Kowalski));
        System.out.println(board.getBlacks());
        var ludus=new Ludii(board);
        System.out.println(ludus);
        var display=new Display(ludus);
//        for(var i=0;i<2*ludus.getBoard().getCharacteristics().getPiecesPerPlayer();i++){
//            var randomCoordinate= Coordinate.random(ludus.getBoard().getCharacteristics());
//            while (!ludus.addPiece(randomCoordinate)) { randomCoordinate= Coordinate.random(ludus.getBoard().getCharacteristics()); }
//            System.out.println(i+"-->"+ludus.getBoard()+" blacks-->"+board.getBlacks().count()+" white-->"+board.getWhites().count());
//            display.resync();
//            Thread.sleep(100);
//        }
        display.resync();
        System.out.println("Done");
    }
}
