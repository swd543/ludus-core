package com.mu.impl;

import com.mu.pieces.*;

import java.util.List;
import java.util.Stack;

/**
 * This is the class that will house our board state logic.
 */
public class Board implements PossibleMoves, IMove, Evaluate, Bell, Ulrich, Kowalski{
    private Piece[][] field;    // the map
                                // 0 = free
                                // 1 = PlayerOneStone
                                // 2 = PlayerTwoStone
                                // 3 = Possible move for Player one
                                // 4 = Possible move for player two
    private Stack<IMove> history;



    private int width;
    private int height;
    private int moveCounter;
    String ruleSet;     // ulrich / bell / kowalski
    Players playerTurn;     // 1 = Player One || 2 = Player Two
    private List<Piece> pieces;

    public Board(int width, int height, String ruleSet){
        this.width = width;
        this.height = height;
        this.field=new Piece[width][height];

        if(ruleSet.equals("ulrich") || !ruleSet.equals("bell") || !ruleSet.equals("kowalski"))
            this.ruleSet = ruleSet;
        else
            System.out.println("ruleset not known");

        //init Field
        init();

        // insert constructor here
    }

    // init field (also good for restart)
    public void init()
    {
//        playerTurn = 1;
//        field = new int[width][height];
//        moveList = new ArrayList<int[][]>();

//        for(int x = 0; x < field.length; x++) {
//            for(int y = 0; < field[x].length; y++){
//                field[x][y] = 0;        //init with "free" field
//            }
//        }

        switch(ruleSet)
        {
            case "ulrich":
//                bufferfield = initUlrich(field);
                break;
            case "bell":
//                bufferField = initBell(field);
                break;
            case "kowalski":
//                bufferField = initKowalski(field);
                break;
            default:
                System.out.println("Set not known!");
        }
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.field=new Piece[width][height];
        this.moveCounter=0;
        this.playerTurn= Players.White; //TODO: This needs to be configurable
    }

    public void undo(){
//        if(moveCounter >= 1)
//        {
//            System.out.println("Undo");
//            field = moveList.get(moveCounter - 1);
//            moveList.remove(moveCounter);
//
//            if(playerTurn == 1)
//                playerTurn = 2;
//            else
//                playerTurn = 1;
//
//            moveCounter--;
//        }
    }

    public int[][] possibleMoves(int[][] field)
    {
        int[][] bufferField = field;

        switch(ruleSet)
        {
            case "ulrich":
//                bufferfield = checkMovesUlrich(field);
                break;
            case "bell":
//                bufferField = checkMovesBell(field);
                break;
            case "kowalski":
//                bufferField = checkMovesKowalski(field);
                break;
            default:
                System.out.println("Set not known!");
        }

        return bufferField;
    }

    @Override
    public List<Coordinate> getPossibleMoves() {
        List<Coordinate> posMoves;

//        for(int x = 0; x < field.length; x++) {
//            for(int y = 0; < field[x].length; y++){
//                if(field[x][y] = playerTurn)
//                {
//                    Coordinate move = new Coordinate(x,y);
//                    posMoves.add(move);
//                }
//            }
//        }
        //same as possible moves, but instead of returning an updated field it returns a list of the moves
        throw new UnsupportedOperationException("This has not been implemented yet");
    }

    /*
        Make move
        Returns:
            -1 = invalid mvoe
            0 = move done
            1 = player one wins
            2 = player two wins
     */
//    @Override
//    public int makeMove(Coordinate to, Coordinate from) {
//
//        //update the Map for possible moves
//        field = possibleMoves(field);
//
//        if( (playerTurn == 1 && field[to.x][to.y] == 3) || (playerTurn == 2 && field[to.x][to.y] == 4) )
//        {
//            //set old field = free
//            field[from.x][from.y] = 0;
//
//            //set the new move
//            if(playerTurn == 1)
//                field[to.x][to.y] == 1;
//            else
//                field[to.x][to.y] == 2;
//
//            //add new move to moveList
//            moveList.add(field);
//            moveCounter++;
//
//            // swap players
//            if(playerTurn == 1)
//                playerTurn = 2;
//            else
//                playerTurn = 1;
//
//            // return and check for win
//            return checkWin(field);
//        }
//        else
//        {
//            return -1;
//        }
//        throw new UnsupportedOperationException("This has not been implemented yet");
//    }

    /*
        ceck the field for win
        returns:
            0 = nobody wins
            1 = player one wins
            2 = player two wins
     */
    public int checkWin(int[][] field) {
        int win = 0;

        switch(ruleSet)
        {
            case "ulrich":
//                win = checkWinUlrich(field);
                break;
            case "bell":
//                win = checkWinBell(field);
                break;
            case "kowalski":
//                win = checkWinKowalski(field);
                break;
            default:
                System.out.println("Set not known!");
        }

        return win;
        //throw new UnsupportedOperationException("This has not been implemented yet");
    }


    // starts the AI returns a coordinate as suggested move
    @Override
    public Coordinate evaluate(int[][] field) {
        throw new UnsupportedOperationException("This has not been implemented yet");
    }

    @Override
    public int[][] initBell(int field) {
        return new int[0][];
    }

    @Override
    public int[][] checkMovesBell(int field) {
        return new int[0][];
    }

    @Override
    public int[][] checkWinBell(int field) {
        return new int[0][];
    }

    @Override
    public void move(Coordinate to, Coordinate from) {

    }

    @Override
    public int[][] initUlrich(int field) {
        return new int[0][];
    }

    @Override
    public int[][] checkMovesUlrich(int field) {
        return new int[0][];
    }

    @Override
    public int[][] checkWinUlrich(int field) {
        return new int[0][];
    }

    @Override
    public int[][] initKowalski(int field) {
        return new int[0][];
    }

    @Override
    public int[][] checkMovesKowalski(int field) {
        return new int[0][];
    }

    @Override
    public int[][] checkWinKowalski(int field) {
        return new int[0][];
    }

    @Override
    public String toString() {
        return "Board{" +
                "width=" + width +
                ", height=" + height +
                ", moveCounter=" + moveCounter +
                ", ruleSet='" + ruleSet + '\'' +
                ", playerTurn=" + playerTurn +
                ", history=" + history +
                ", field=\n" + getBoardRepresentation().toString() +
                '}';
    }

    private StringBuffer getBoardRepresentation(){
        return getBoardRepresentation(1);
    }

    private StringBuffer getBoardRepresentation(int spacing){
        var boardRepresentation=new StringBuffer();
        StringBuilder space= new StringBuilder();
        for(var i=0;i<spacing;i++){
            space.append(" ");
        }
        for(var i:field){
            for(var j:i){
                if (j instanceof Black)
                    boardRepresentation.append("B");
                else if(j instanceof White)
                    boardRepresentation.append("W");
                else if(j instanceof Dux)
                    boardRepresentation.append("D");
                else
                    boardRepresentation.append("_");
                boardRepresentation.append(space.toString());
            }
            boardRepresentation.append("\n");
        }
        return boardRepresentation;
    }

    public Piece[][] getField() { return field; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public List<Piece> getPieces() { return pieces; }
    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
        for(var p:pieces){
            Coordinate.assign(getField(), p, p.getLocation());
        }
    }
}
