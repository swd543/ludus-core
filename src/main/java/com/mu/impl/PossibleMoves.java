package com.mu.impl;

import java.util.List;

public interface PossibleMoves {
    public List<Coordinate> getPossibleMoves();
    public int[][] possibleMoves(int[][] field);
}
