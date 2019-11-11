package com.mu.impl;

import java.util.List;

public interface PossibleMoves {
    public List<Coodrinate> getPossibleMoves();
    public int[][] possibleMoves(int[][] field);
}
