package chess;

public enum Color {
    WHITE("white",'p'), BLACK("black",'P');
    private final String colorName;
    private final char representation;

    //생성자
    Color(String colorName, char representation) {
        this.colorName = colorName;
        this.representation = representation;
    }

    public String getColorName(){
        return colorName;
    }

    public char getRepresentation(){
        return representation;
    }
}
