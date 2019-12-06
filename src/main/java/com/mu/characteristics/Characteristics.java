package com.mu.characteristics;

/**
 * This will be the class that should contain ALL the necessary customisations for all interpretations
 */
public class Characteristics {
    private boolean isOrthogonalMoveAllowed;
    private int numberOfPiecesPerPlayer=5;

    public Characteristics(boolean isOrthogonalMoveAllowed, int numberOfPiecesPerPlayer, Movement black, Movement white, Movement dux) {
        this.isOrthogonalMoveAllowed = isOrthogonalMoveAllowed;
        this.numberOfPiecesPerPlayer = numberOfPiecesPerPlayer;
        this.black = black;
        this.white = white;
        this.dux = dux;
    }

    // test
    public Characteristics(){}

    private Movement black=new Movement();
    private Movement white=new Movement();
    private Movement dux=new Movement(false, false, Integer.MAX_VALUE);

    public boolean isOrthogonalMoveAllowed() {
        return isOrthogonalMoveAllowed;
    }

    public Characteristics setOrthogonalMoveAllowed(boolean orthogonalMoveAllowed) {
        isOrthogonalMoveAllowed = orthogonalMoveAllowed;
        return this;
    }

    public Characteristics setNumberOfPiecesPerPlayer(int numberOfPiecesPerPlayer) {
        this.numberOfPiecesPerPlayer = numberOfPiecesPerPlayer;
        return this;
    }

    public Characteristics setBlack(Movement black) {
        this.black = black;
        return this;
    }

    public Characteristics setWhite(Movement white) {
        this.white = white;
        return this;
    }

    public Characteristics setDux(Movement dux) {
        this.dux = dux;
        return this;
    }

    public int getNumberOfPiecesPerPlayer() {
        return numberOfPiecesPerPlayer;
    }

    public Movement getBlack() {
        return black;
    }

    public Movement getWhite() {
        return white;
    }

    public Movement getDux() {
        return dux;
    }

    // Some interpretations. Can be tweaked as necessary TODO: fill up the actual characteristics
    public static Characteristics kowalski(){
        return new Characteristics();
    }

    public static Characteristics ulrich(){
        return new Characteristics();
    }

    public static Characteristics bell(){
        return new Characteristics();
    }

    @Override
    public String toString() {
        return "Characteristics{" +
                "isOrthogonalMoveAllowed=" + isOrthogonalMoveAllowed +
                ", numberOfPiecesPerPlayer=" + numberOfPiecesPerPlayer +
                ", black=" + black +
                ", white=" + white +
                ", dux=" + dux +
                '}';
    }
}
