package com.mu.game.piece;

import java.awt.*;

public enum PieceType {
    WHITE("W", Color.WHITE),
    BLACK("B", Color.BLACK),
    WHITEDUX("WD", Color.BLUE.brighter().brighter().brighter().brighter().brighter()),
    BLACKDUX("BD", Color.BLUE.darker().darker());

    private final String alias;
    private final Color color;

    PieceType(String alias, Color color) {
        this.alias = alias;
        this.color = color;
    }

    public Color getColor() { return color; }
    public String getAlias() { return alias; }

    /**
     * Get dux of the piece type regardless of the player
     * white/whitedux=>whitedux
     * black/blackdux=>blackdux
     * @return dux
     */
    public PieceType getDux(){ return getPieceType(WHITEDUX, BLACKDUX); }

    /**
     * Get primary color of the piece type regardless of the player
     * white/whitedux=>white
     * black/blackdux=>black
     * @return primaryPiece
     */
    public PieceType getPrimary(){ return getPieceType(WHITE, BLACK); }

    private PieceType getPieceType(PieceType white, PieceType black) {
        switch (this){
            case WHITE:
            case WHITEDUX:
                return white;
            case BLACK:
            case BLACKDUX:
                return black;
            default:
                return null;
        }
    }

    @Override
    public String toString() { return alias; }
}
