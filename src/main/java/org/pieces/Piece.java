package org.pieces;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';


    private final String color;
    private final String name;
    private final char representation;

    private Piece(String color,String name){
        this.color = color;
        this.name = name;
        if(color.equals(WHITE_COLOR)) representation = WHITE_PAWN_REPRESENTATION;
        else representation = BLACK_PAWN_REPRESENTATION;
    }

    public String getColor(){
        return color;
    }

    public char getRepresentation(){
        return representation;
    }

    public static Piece createWhitePawn(){
        return new Piece(Piece.WHITE_COLOR,"pawn");
    }

    public static Piece createBlackPawn(){
        return new Piece(Piece.BLACK_COLOR,"pawn");
    }
}
