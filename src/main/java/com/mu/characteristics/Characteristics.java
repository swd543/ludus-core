package com.mu.characteristics;

public class Characteristics {
    private boolean isJumpAllowed;

    private boolean isDiagonalJumpAllowed;

    private boolean isOrthogonalMoveAllowed;

    private Integer numberOfPiecesPerPlayer;

    public boolean isDiagonalJumpAllowed() {
        return isJumpAllowed && isDiagonalJumpAllowed;
    }

    public boolean isJumpAllowed() {
        return isJumpAllowed;
    }
}
