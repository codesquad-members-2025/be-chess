package pieces;

public class Position {
    private static String position;

    public Position(String position){
        this.position = position;
    }

    public int getX(){
        int x = position.charAt(0) - 'a';
        return x;
    }

    public int getY(){
        int y = 8 - (position.charAt(1) - '0');
        return y;
    }
}
