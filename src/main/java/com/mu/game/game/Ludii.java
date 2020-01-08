package com.mu.game.game;

import com.mu.game.characteristics.Characteristics;
import com.mu.game.piece.Coordinate;
import com.mu.game.piece.PieceType;
import com.mu.game.util.BadMoveException;

public class Ludii {
    private IBoard board;
    private PieceType playerToMove;
    private boolean isAllPiecesSet=false;
    private boolean setDux=false;

    public Ludii(IBoard board, PieceType playerToMove) {
        this.board = board;
        this.playerToMove = playerToMove;
    }

    public Ludii(Characteristics characteristics, PieceType playerToMove){ this(new Board(characteristics), playerToMove); }

    public Ludii(Characteristics characteristics){ this(characteristics, characteristics.getStartingPlayer()); }

    public Ludii(IBoard board){ this(board, board.getCharacteristics().getStartingPlayer()); }

    /**
     * Add a piece as per the ruleset, to the location
     * @param coordinate
     * @return whether piece was set
     */
    public boolean addPiece(Coordinate coordinate){
        var characteristics=board.getCharacteristics();
        var playerCount=board.getPieces(getPlayerToMove()).count();
        var playerDuxCount=board.getPieces(getPlayerToMove().getDux()).count();
        System.out.println(isAllPiecesSet+" "+setDux+" "+playerToMove+" "+playerCount+" "+playerDuxCount);
        if(playerCount+playerDuxCount>=characteristics.getPiecesPerPlayer()){ isAllPiecesSet=true; setDux=false; }
        else if(playerCount==characteristics.getPiecesPerPlayer()-1){ isAllPiecesSet=false; setDux=true; }
        if (isAllPiecesSet) throw new BadMoveException("All pieces have already been set. Cannot add another. Maybe you meant move()?");
        var isSet=board.set(coordinate, characteristics.hasDux() && setDux ? playerToMove.getDux():playerToMove, true);
        System.out.println(playerToMove.getDux());
        System.out.println(board);
        if(isSet){switchPlayer();}
        return isSet;
    }

    public boolean move(Coordinate to, Coordinate from){
        var player=board.getPieceAt(from);
        if(player!=playerToMove) throw new BadMoveException();
        return board.move(to, from);
    }

    public void reset(){
        board.reset();
        playerToMove=board.getCharacteristics().getStartingPlayer();
        isAllPiecesSet=false;
        setDux=false;
    }

    public void switchPlayer(){
        if(playerToMove==PieceType.WHITE){playerToMove=PieceType.BLACK;}
        else if(playerToMove==PieceType.BLACK){playerToMove=PieceType.WHITE;}
    }

    public PieceType getPlayerToMove() { return playerToMove; }

    public IBoard getBoard() { return board; }

    @Override
    public String toString() {
        return "Ludii{" +
                "board=" + board +
                ", playerToMove=" + playerToMove +
                '}';
    }
}
