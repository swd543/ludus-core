package com.mu.game.characteristics;

import com.mu.game.piece.PieceType;

public class Characteristics {
    private final int height, width;

    /**
     * The number of pieces INCLUDING DUX
     */
    private final int piecesPerPlayer;
    private final boolean hasDux;
    private final Movement primary, dux;
    private final PieceType startingPlayer;
    private final boolean manuallySetPieces;

    public Characteristics() { this(8,8); }

    public Characteristics(int height, int width) { this(height, width, new Movement(), new Movement(), PieceType.WHITE, 8, false, true); }

    public Characteristics(int height, int width, Movement primary, Movement dux, PieceType startingPlayer, int piecesPerPlayer, boolean hasDux, boolean manuallySetPieces) {
        this.height = height;
        this.width = width;
        this.primary = primary;
        this.dux = dux;
        this.startingPlayer=startingPlayer;
        this.piecesPerPlayer=piecesPerPlayer;
        this.hasDux=hasDux;
        this.manuallySetPieces=manuallySetPieces;
    }

    public int getHeight() { return height; }
    public int getWidth() { return width; }
    public Movement getPrimary() { return primary; }
    public Movement getDux() { return dux; }
    public PieceType getStartingPlayer() { return startingPlayer; }
    public int getPiecesPerPlayer() { return piecesPerPlayer; }
    public boolean hasDux() { return hasDux; }
    public boolean isManuallySetPieces() { return manuallySetPieces; }

    public static Characteristics getCharacteristics(Ruleset ruleset){
        switch (ruleset){
            case Ulrich:
                return new Characteristics(8,8,
                        new Movement().setCanJump(true).setJumpBehaviour(Behaviour.JUMP_OVER_ANY_PIECE),
                        new Movement().setCanJump(false).setCanMoveDiagonal(false).setDistanceCanMove(Integer.MAX_VALUE).setNumberOfJumps(0),
                        PieceType.WHITE,
                        16, // 16-24
                        false,
                        true
                );
            case Bell:
                return new Characteristics(7,8,
                        new Movement().setCanJump(false).setNumberOfJumps(0),
                        new Movement().setCanJump(true).setDistanceCanMove(1).setJumpBehaviour(Behaviour.JUMP_OVER_OPPOSITE_COLOR_ONLY),
                        PieceType.WHITE,
                        17,
                        true,
                        true
                );
            case Kowalski:
                return new Characteristics(8,12,
                        new Movement().setCanJump(false).setNumberOfJumps(0).setDistanceCanMove(Integer.MAX_VALUE),
                        new Movement().setCanJump(false).setNumberOfJumps(0).setDistanceCanMove(Integer.MAX_VALUE),
                        PieceType.WHITE,
                        13,
                        true,
                        false
                );
            default:
                throw new UnsupportedOperationException(ruleset+" is not implemented yet. Please bear with us or use another ruleset!");
        }
    }
}
