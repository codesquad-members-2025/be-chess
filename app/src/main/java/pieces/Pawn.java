package pieces;

public class Pawn {
    private String color;

    public final static String WHITE_COLOR = "white";
    public final static String BLACK_COLOR = "black";

    public Pawn() {
        this.color = WHITE_COLOR;
    }

    public Pawn(String color){
        this.color = color;
    }

    public String getColor(){
        return color;
    }
}
