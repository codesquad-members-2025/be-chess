package chess;

public class Position {
    private final int row;
    private final int col;

    public Position(String position) { //a8
        this.col = position.charAt(0) - 'a'; //a->0, b -> 1, ...
        this.row = 8 - Character.getNumericValue(position.charAt(1)); //8> 0, 7 -> 1, ...
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
