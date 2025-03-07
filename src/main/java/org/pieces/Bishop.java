package org.pieces;

import org.chess.Coordinate;
import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece{
    public Bishop(Color color){
        super(color,Type.BISHOP);
    }

    @Override
    public boolean verifyMovePosition(Coordinate sourcePosition, Coordinate targetPosition){
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
