package pieces;

import java.util.Objects;

public class Position {
    private String position;

    public Position(String position){
        this.position = position;
    }

    public int getX(){
        return position.charAt(0) - 'a';
    }

    public int getY(){
        return 8 - (position.charAt(1) - '0');
    }

    public Position move(Direction direction){
        char x = (char) (position.charAt(0) + direction.getXDegree());
        char y = (char) (position.charAt(1) + direction.getYDegree());
        return new Position("" + x + y);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position other = (Position) obj;
        return Objects.equals(this.position, other.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return position;
    }
}
