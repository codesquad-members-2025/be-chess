package org.pieces;

public class Pawn {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION = 'P';

    private final String color;
    private final char representation;

    public Pawn(){
        this(Pawn.WHITE_COLOR);
    }

    public Pawn(String color){
        this.color = color;
        if(color == WHITE_COLOR) representation = WHITE_REPRESENTATION;
        else representation = BLACK_REPRESENTATION;
    }

    public String getColor(){
        return color;
    }

    public char getRepresentation(){
        return representation;
    }

}
