package org.chess;

public class Coordinate {
    private final int rankIndex;
    private final int fileIndex;

    public Coordinate(String location){
        if(!isValid(location)) throw new IllegalArgumentException("잘못된 좌표입니다.");
        rankIndex = Character.getNumericValue(location.charAt(1))-1;
        fileIndex = location.charAt(0)-'a';
    }

    private boolean isValid(String location){
        char file =location.charAt(0);
        char rank =location.charAt(1);
        if(!(file>='a' && file<='h')) return false;
        if(!(rank>='1' && rank<='8')) return false;
        return true;
    }

    int getRankIndex(){
        return rankIndex;
    }

    int getFileIndex(){
        return fileIndex;
    }

}