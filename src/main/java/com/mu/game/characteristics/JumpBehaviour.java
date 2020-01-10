package com.mu.game.characteristics;

import com.mu.game.piece.PieceType;

import java.util.function.BiPredicate;

public class JumpBehaviour {
    public static final BiPredicate<PieceType, PieceType> JUMP_OVER_OPPOSITE_COLOR_ONLY=(a, b)->a.getPrimary()!=b.getPrimary(); // no need to null check, will throw NPE if null
    public static final BiPredicate<PieceType, PieceType> JUMP_OVER_ANY_PIECE=(a, b)->true;
}
