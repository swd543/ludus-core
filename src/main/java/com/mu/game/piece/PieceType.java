package com.mu.game.piece;

import java.awt.*;

public enum PieceType {
    WHITE("W", Color.WHITE),
    BLACK("B", Color.BLACK),
    WHITEDUX("WD", Color.BLUE.brighter().brighter()),
    BLACKDUX("BD", Color.BLUE.darker().darker());

    private final String alias;
    private final Color color;

    PieceType(String alias, Color color) {
        this.alias = alias;
        this.color = color;
    }

    public Color getColor() { return color; }
    public String getAlias() { return alias; }
    public PieceType getDux(){
        switch (this){
            case WHITE:
            case WHITEDUX:
                return WHITEDUX;
            case BLACK:
            case BLACKDUX:
                return BLACKDUX;
            default:
                return null;
        }
    }

    @Override
    public String toString() { return alias; }
}
