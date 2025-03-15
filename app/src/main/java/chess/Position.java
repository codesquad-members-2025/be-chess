package chess;

public class Position {

    private int y;

    private int x;

    public Position(String positionInfo) {
        char y = positionInfo.charAt(1);
        this.y = Character.getNumericValue(y) - 1;

        char x = positionInfo.charAt(0);
        this.x = x - 'a';
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
