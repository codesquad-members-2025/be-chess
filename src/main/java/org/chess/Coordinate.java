package org.chess;

public class Coordinate {
    private final int fileIndex;
    private final int rankIndex;

    public Coordinate(int fileIndex, int rankIndex) {
        if (!isValid(fileIndex, rankIndex)) throw new IllegalArgumentException("잘못된 좌표입니다.");
        this.fileIndex = fileIndex;
        this.rankIndex = rankIndex;
    }

    public Coordinate(String location) {
        this(location.charAt(0) - 'a', Character.getNumericValue(location.charAt(1)) - 1);
    }

    private boolean isValid(int fileIndex, int rankIndex) {
        return fileIndex >= 0 && fileIndex < 8 && rankIndex >= 0 && rankIndex < 8;
    }

    public Coordinate moveCoordinate(int fileDegree, int rankDegree) {
        return new Coordinate(fileIndex + fileDegree, rankIndex + rankDegree);
    }

    int getRankIndex() {
        return rankIndex;
    }

    int getFileIndex() {
        return fileIndex;
    }

}