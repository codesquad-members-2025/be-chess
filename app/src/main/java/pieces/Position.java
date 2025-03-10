package pieces;

public class Position {
    private String position;

    public Position(String position){
        this.position = position;
    }

    public static int getX(String location){
        int x = location.charAt(0) - 'a';
        return x;
    }

    public static int getY(String location){
        int y = 8 - (location.charAt(1) - '0');
        return y;
    }
}
