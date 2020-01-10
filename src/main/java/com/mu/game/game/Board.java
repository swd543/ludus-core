package com.mu.game.game;

import com.mu.game.characteristics.Behaviour;
import com.mu.game.characteristics.Characteristics;
import com.mu.game.characteristics.Movement;
import com.mu.game.piece.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Board implements IBoard {
    private Blacks blacks;
    private Whites whites;
    private Duxes blackDuxes, whiteDuxes;
    private final Characteristics characteristics;

    public Blacks getBlacks() { return blacks; }
    public Whites getWhites() { return whites; }
    public Duxes getBlackDuxes() { return blackDuxes; }
    public Duxes getWhiteDuxes() { return whiteDuxes; }

    public Board(Characteristics characteristics) {
        if(characteristics.getHeight()>characteristics.getWidth()) throw new UnsupportedOperationException("Boards with height > width still not supported by this program!");
        this.characteristics = characteristics;
        reset();
    }

    @Override
    public Pieces getPieces(PieceType p) {
        switch (p){
            case BLACK:
                return getBlacks();
            case BLACKDUX:
                return getBlackDuxes();
            case WHITEDUX:
                return getWhiteDuxes();
            default:
                return getWhites();
        }
    }

    @Override
    public PieceType getPieceAt(Coordinate location){
        if(blacks.at(location)) return PieceType.BLACK;
        else if(whites.at(location)) return PieceType.WHITE;
        else if(blackDuxes.at(location)) return PieceType.BLACKDUX;
        else if(whiteDuxes.at(location)) return PieceType.WHITEDUX;
        else return null;
    }

    @Override
    public boolean set(Coordinate coordinate, PieceType pieceType, boolean set){
        var isOccupied=isOccupied(coordinate);
        if(coordinate.isValidIndex(this) && (isOccupied^set)){
            switch (pieceType){
                case BLACK: blacks.setAt(coordinate, set); break;
                case WHITE: whites.setAt(coordinate, set); break;
                case BLACKDUX: blackDuxes.setAt(coordinate, set); break;
                case WHITEDUX: whiteDuxes.setAt(coordinate, set); break;
            }
            return true;
        } else { return false; }
    }

    @Override
    public boolean move(Coordinate to, Coordinate from){
        if(to.isValidIndex(this) && !isOccupied(to)){
            var piece=getPieceAt(from);
            if(piece==null) return false;
            set(to, piece, true);
            set(from, piece, false);
            return true;
        }
        return false;
    }

    @Override
    public void reset(){
        this.blacks= new Blacks(characteristics.getWidth(), characteristics.getHeight(), this);
        this.whites= new Whites(characteristics.getWidth(), characteristics.getHeight(), this);
        this.whiteDuxes = new Duxes(characteristics.getWidth(), characteristics.getHeight(), this);
        this.blackDuxes = new Duxes(characteristics.getWidth(), characteristics.getHeight(), this);
    }

    @Override
    public Set<Coordinate> getValidMoves(Coordinate from){
        Set<Coordinate> set=new HashSet<>();
        try{
            var movement=getCharacteristics(getPieceAt(from));
            for(var c:Coordinate.DIRECTIONS){
                for(var i=1;i<=movement.getDistanceCanMove();i++){
                    var newCoord=c.multiply(i).add(from);
                    var isValid=newCoord.isValidIndex(this) && !isOccupied(newCoord);
                    if(isValid){ set.add(newCoord); }
                    else break;
                }
            }
            // Find jump moves only if piece can jump and distance to move is 1, multiple moves and jumps undefined!
            if(movement.getDistanceCanMove()==1 && movement.isCanJump()){
                var pieceType=getPieceAt(from);
                var jumpBehaviour=(PieceType.WHITEDUX==pieceType || PieceType.BLACKDUX==pieceType)?
                        characteristics.getDux().getJumpBehaviour():
                        characteristics.getPrimary().getJumpBehaviour();
                findPossibleMovesRecursive(0, movement, set, pieceType, jumpBehaviour, from, new AtomicReference<>(null));
            }
        } catch (NullPointerException ignored){ }
        return set;
    }

    @Override
    public Map<Coordinate, PieceType> getNeighbours(Coordinate from, BiPredicate<PieceType, PieceType> filter, Predicate<Coordinate> direction, boolean absoluteCoordinate){
        var map=new HashMap<Coordinate, PieceType>();
        var piece=getPieceAt(from);
        BiFunction<Coordinate, Coordinate, Coordinate> coordinateGetter=absoluteCoordinate?
                (absolutePosition, relativePosition)-> absolutePosition:
                (absolutePosition, relativePosition)-> relativePosition;
        for(var d:Coordinate.DIRECTIONS){
            if(direction.test(d)) continue;
            var newCoordinate=d.add(from);
            if(!newCoordinate.isValidIndex(this)) continue;
            try{
                var newPiece=getPieceAt(newCoordinate);
                if(filter.test(piece, newPiece)){ map.put(coordinateGetter.apply(newCoordinate, d), newPiece); }
            } catch (ArrayIndexOutOfBoundsException ignored) { }
        }
        return map;
    }

    @Override
    public Map<Coordinate, PieceType> getNeighbours(Coordinate from){
        return getNeighbours(from, (a,b)-> b!=null);
    }

    @Override
    public Map<Coordinate, PieceType> getNeighbours(Coordinate from, BiPredicate<PieceType, PieceType> filter, boolean absoluteCoordinate){
        return getNeighbours(from, filter, coordinate -> false, absoluteCoordinate);
    }

    @Override
    public Map<Coordinate, PieceType> getNeighbours(Coordinate from, boolean absoluteCoordinate){
        return getNeighbours(from, (a,b)-> b!=null, absoluteCoordinate);
    }

    @Override
    public Map<Coordinate, PieceType> getNeighbours(Coordinate from, BiPredicate<PieceType, PieceType> filter){
        return getNeighbours(from, filter, coordinate -> false);
    }

    @Override
    public Map<Coordinate, PieceType> getNeighbours(Coordinate from, BiPredicate<PieceType, PieceType> filter, Predicate<Coordinate> direction){
        return getNeighbours(from, filter, direction, true);
    }

    public String getBoardDisplay(){
        var sb=new StringBuilder();
        for(var i=0;i<characteristics.getHeight();i++){
            for(var j=0;j<characteristics.getWidth();j++){ sb.append(String.format("%-5s", getPieceAt(new Coordinate(j, i)))); }
            sb.append("\n");
        }
        sb.setLength(sb.length()-1);
        return sb.toString();
    }

    private void findPossibleMovesRecursive(int count, Movement movement, Set<Coordinate> possible, PieceType p, BiPredicate<PieceType, PieceType> jumpBehaviour, Coordinate current, AtomicReference<Coordinate> previousDirection){
        if(count>movement.getNumberOfJumps()) return;
        if(possible.contains(current)) return;
        var oppositeNeighbours=getNeighbours(current, (a,b)-> b!=null && jumpBehaviour.test(p,b), d->d.minus().equals(previousDirection.get()));
        oppositeNeighbours.forEach(((coordinate, pieceType) -> {
            var direction=coordinate.minus(current);
            previousDirection.set(direction);
            var jumpCoord=direction.multiply(2).add(current);
            if(!jumpCoord.isValidIndex(this) || isOccupied(jumpCoord)) return;
            findPossibleMovesRecursive(count+1, movement, possible, p, jumpBehaviour, jumpCoord, previousDirection);
            possible.add(jumpCoord);
        }));
    }

    public boolean isOccupied(Coordinate location){ return blacks.at(location) || whites.at(location) || blackDuxes.at(location) || whiteDuxes.at(location); }

    public Characteristics getCharacteristics() { return characteristics; }
    public Movement getCharacteristics(PieceType p) {
        switch (p){
            case BLACK:
            case WHITE:
                return characteristics.getPrimary();
            case BLACKDUX:
            case WHITEDUX:
                return characteristics.getDux();
            default:
                return null;
        }
    }

    @Override
    public String toString() {
        return "Board{" +
                "blacks=" + blacks +
                ", whites=" + whites +
                ", duxes=" + blackDuxes +
                ", characteristics=" + characteristics
                +"\n"+getBoardDisplay()+
                '}';
    }
}
