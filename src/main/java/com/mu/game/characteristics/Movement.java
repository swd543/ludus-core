package com.mu.game.characteristics;

import com.mu.game.piece.PieceType;

import java.util.function.BiPredicate;

public class Movement {
    private boolean canMoveDiagonal=false;
    private boolean canJump=true;
    private int distanceCanMove=1;
    private int numberOfJumps=Integer.MAX_VALUE;

    private BiPredicate<PieceType, PieceType> jumpBehaviour= JumpBehaviour.JUMP_OVER_OPPOSITE_COLOR_ONLY;

    public boolean isCanMoveDiagonal() { return canMoveDiagonal; }

    public Movement setCanMoveDiagonal(boolean canMoveDiagonal) {
        this.canMoveDiagonal = canMoveDiagonal;
        return this;
    }

    public boolean isCanJump() { return canJump; }

    public Movement setCanJump(boolean canJump) {
        this.canJump = canJump;
        return this;
    }

    public int getDistanceCanMove() { return distanceCanMove; }

    public Movement setDistanceCanMove(int distanceCanMove) {
        this.distanceCanMove = distanceCanMove;
        return this;
    }
    public int getNumberOfJumps() { return numberOfJumps; }

    public Movement setNumberOfJumps(int numberOfJumps) {
        this.numberOfJumps = numberOfJumps;
        return this;
    }

    public BiPredicate<PieceType, PieceType> getJumpBehaviour() { return jumpBehaviour; }

    public Movement setJumpBehaviour(BiPredicate<PieceType, PieceType> jumpBehaviour) {
        this.jumpBehaviour = jumpBehaviour;
        return this;
    }
}
