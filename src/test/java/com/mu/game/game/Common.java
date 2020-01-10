package com.mu.game.game;

import com.mu.game.characteristics.Characteristics;
import com.mu.game.characteristics.Movement;
import com.mu.game.piece.PieceType;

public class Common {
    static Characteristics testCharacteristics=new Characteristics(8,8,
            new Movement(),
            new Movement(),
            PieceType.WHITE,
            8,
            true,
            true);
}
