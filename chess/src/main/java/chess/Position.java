package chess;

public class Position {


    private final int x;
    private final int y;

    public Position(String position){
        this.x = position.charAt(0) - 'a';
        this.y = position.charAt(1) - '1';

    }

    public int getX(){
        return x;
    }

    public int getY(){
        return 7-y;
    }
}
