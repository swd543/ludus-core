package com.mu.game.util;

public class BadMoveException extends UnsupportedOperationException {
    public BadMoveException() { super("Invalid move played!"); }

    public BadMoveException(String message) { super(message); }
}
