package chess;

public class Pawn {
    String color;
    char representation;

    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";

    //Pawn 색에 따른 출력 문자 부여
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION ='P' ;

    public Pawn(String color) {
        this.color=color;
    }
    //색이 없는 경우 기본으로 흰색(white)의 말을 생성
    public Pawn(){
        this.color="white";
    }

    public Pawn(String color, char representation) {
        this.color=color;
        this.representation=representation;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char getRepresentation() {
        if(color.equals(BLACK_COLOR)){
            return 'P';
        }
        else return 'p';
    }
}