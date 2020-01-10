package com.mu.game.characteristics;

import com.mu.game.piece.PieceType;

import java.util.function.BiPredicate;

public class Behaviour {
    public static final BiPredicate<PieceType, PieceType> JUMP_OVER_OPPOSITE_COLOR_ONLY=(a, b)->a.getPrimary()!=b.getPrimary();
    public static final BiPredicate<PieceType, PieceType> JUMP_OVER_ANY_PIECE=(a, b)->true;
}
