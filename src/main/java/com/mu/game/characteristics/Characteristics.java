package com.mu.game.characteristics;

import com.mu.game.piece.PieceType;

public class Characteristics {
    private final int height, width;
    private final int piecesPerPlayer;
    private final boolean hasDux;
    private final Movement black, white, dux;
    private final PieceType startingPlayer;
    private final boolean manuallySetPieces;

    public Characteristics() { this(8,8); }

    public Characteristics(int height, int width) { this(height, width, new Movement(), new Movement(), new Movement(), PieceType.WHITE, 8, false, true); }

    public Characteristics(int height, int width, Movement black, Movement white, Movement dux, PieceType startingPlayer, int piecesPerPlayer, boolean hasDux, boolean manuallySetPieces) {
        this.height = height;
        this.width = width;
        this.black = black;
        this.white = white;
        this.dux = dux;
        this.startingPlayer=startingPlayer;
        this.piecesPerPlayer=piecesPerPlayer;
        this.hasDux=hasDux;
        this.manuallySetPieces=manuallySetPieces;
    }

    public int getHeight() { return height; }
    public int getWidth() { return width; }
    public Movement getBlack() { return black; }
    public Movement getWhite() { return white; }
    public Movement getDux() { return dux; }
    public PieceType getStartingPlayer() { return startingPlayer; }
    public int getPiecesPerPlayer() { return piecesPerPlayer; }
    public boolean hasDux() { return hasDux; }
    public boolean isManuallySetPieces() { return manuallySetPieces; }

    public static Characteristics getCharacteristics(Ruleset ruleset){
        switch (ruleset){
            case Ulrich:
                return new Characteristics(8,8,
                        new Movement(),
                        new Movement(),
                        new Movement().setCanJump(false).setCanMoveDiagonal(false).setDistanceCanMove(Integer.MAX_VALUE).setNumberOfJumps(0),
                        PieceType.WHITE,
                        16, // 16-24
                        false,
                        true
                );
            case Bell:
                return new Characteristics(7,8,
                        new Movement().setCanJump(false).setNumberOfJumps(0),
                        new Movement().setCanJump(false).setNumberOfJumps(0),
                        new Movement().setCanJump(true).setDistanceCanMove(1),
                        PieceType.WHITE,
                        17,
                        true,
                        false
                );
            default:
                throw new UnsupportedOperationException(ruleset+" is not implemented yet. Please bear with us or use another ruleset!");
        }
    }
}
