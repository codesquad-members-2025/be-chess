package org.pieces;

import org.chess.Coordinate;
import java.util.HashSet;
import java.util.Set;

public class Queen extends Piece{
    public Queen(Color color){
        super(color,Type.QUEEN);
    }

    @Override
    public boolean verifyMovePosition(Coordinate sourcePosition, Coordinate targetPosition){
        Set<Coordinate> coordinateSet = new HashSet<>();
        for(Direction direction : Direction.everyDirection()){
            int fileDegree = direction.getFileDegree();
            int rankDegree = direction.getRankDegree();
            for(int i = 1; i<8;i++){
                Coordinate movedCoordinate = sourcePosition.shiftCoordinate(fileDegree*i,rankDegree*i);
                if(movedCoordinate.isCoordinateOnBoard()) coordinateSet.add(movedCoordinate);
                else break;
            }
        }
        return coordinateSet.contains(targetPosition);
    }
}
