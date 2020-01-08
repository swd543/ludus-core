package com.mu.game.piece;

import com.mu.game.game.Board;
import com.mu.game.util.Utility;

public class Pieces implements Cloneable{
    public static final int SIZE_OF_LONG=64;
    private long[] locations;
    private final Board board;

    public Pieces(int boardWidth, int boardHeight, Board board){
        this(boardWidth*boardHeight, board);
    }

    public Pieces(int boardSize, Board board) {
        var numberOfLongsRequired=(int)Math.ceil((double) boardSize/SIZE_OF_LONG);
        locations=new long[numberOfLongsRequired];
        this.board=board;
    }

    Pieces(){
        this(SIZE_OF_LONG, null);
    }
    Pieces(int boardSize){ this(boardSize, null); }

    public boolean at(Coordinate c){ return getNthBit(c.collapse(board.getCharacteristics().getHeight())); }

    public long[] getLocations() { return locations; }

    public boolean setNthBit(int n, boolean value){
        checkValidIndex(n);
        var bank=n/SIZE_OF_LONG;
        var offset=n%SIZE_OF_LONG;
        if(value) locations[bank] |= 1L << offset;
        else locations[bank]&=~(1L<<offset);
        return value;
    }

    public long count(){
        var sum= 0L;
        for(var location:locations){ sum+=Long.bitCount(location); }
        return sum;
    }

    public boolean setAt(Coordinate coordinate, boolean value){ return setNthBit(coordinate.collapse(board.getCharacteristics().getHeight()), value); }

    private void checkValidIndex(int n){ if(n>locations.length*SIZE_OF_LONG) throw new ArrayIndexOutOfBoundsException(n+"th bit was accessed when max length permitted is "+locations.length*SIZE_OF_LONG); }

    public boolean getNthBit(int n){
        checkValidIndex(n);
        var bank=(n/SIZE_OF_LONG);
        var offset=n%SIZE_OF_LONG;
        return (locations[bank]>>offset & 1L) == 1L;
    }

    @Override
    public String toString() {
        var sb=new StringBuilder();
        for(var l:locations){ sb.append(Utility.getBinaryString(l)).append(","); }
        return "Pieces{" + sb.toString() + '}';
    }

    @Override
    public Pieces clone() throws CloneNotSupportedException {
        var x=(Pieces) super.clone();
        x.locations=this.locations.clone();
        return x;
    }
}
