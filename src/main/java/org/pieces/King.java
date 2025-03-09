package org.pieces;

import org.chess.Board;
import org.chess.Coordinate;
import java.util.HashSet;
import java.util.Set;

public class King extends Piece{
    public King(Color color){
        super(color,Type.KING);
    }

    @Override
    public boolean verifyMovePosition(Board board, Coordinate sourcePosition, Coordinate targetPosition){
        Set<Coordinate> coordinateSet = new HashSet<>();
        for(Direction direction : Direction.everyDirection()){
            int fileDegree = direction.getFileDegree();
            int rankDegree = direction.getRankDegree();
            Coordinate movedCoordinate = sourcePosition.shiftCoordinate(fileDegree,rankDegree);
            if(movedCoordinate.isCoordinateOnBoard()) coordinateSet.add(movedCoordinate);
        }
        return coordinateSet.contains(targetPosition);
    }
}
