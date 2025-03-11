package org.chess;

import java.util.Objects;

public class Coordinate {
    private final int fileIndex;
    private final int rankIndex;

    public Coordinate(int fileIndex, int rankIndex) {
        this.fileIndex = fileIndex;
        this.rankIndex = rankIndex;
    }

    public Coordinate(String location) {
        if(!checkValidityInput(location)) throw new IllegalArgumentException("좌표 양식과 다릅니다.");
        this.fileIndex = location.charAt(0) - 'a';
        this.rankIndex = Character.getNumericValue(location.charAt(1)) - 1;
    }

    public boolean isCoordinateOnBoard() {
        return fileIndex >= 0 && fileIndex < 8 && rankIndex >= 0 && rankIndex < 8;
    }

    public Coordinate shiftCoordinate(int fileDegree, int rankDegree) {
        return new Coordinate(fileIndex + fileDegree, rankIndex + rankDegree);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Coordinate coordinate = (Coordinate) obj;
        return (fileIndex == coordinate.fileIndex && rankIndex == coordinate.rankIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fileIndex, rankIndex);
    }

    public int getRankIndex() {
        return rankIndex;
    }

    public int getFileIndex() {
        return fileIndex;
    }

    private boolean checkValidityInput(String location) {
        if (location.length() !=2) return false;
        if (location.charAt(0) < 'a' && location.charAt(0) > 'z') return false;
        if (!Character.isDigit(location.charAt(1))) return false;
        return true;
    }
}
