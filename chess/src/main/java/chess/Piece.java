package chess;

public class Piece { //Pawn 클래스 이름을 Piece로 rename

    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";
    //Pawn 색에 따른 출력 문자 부여
    public static final char WHITE_REPRESENTATION = 'p';
    public static final char BLACK_REPRESENTATION ='P' ;

    private final Type type;
    private final Color color;


    public Piece(Color color, Type type) {
        this.color= color;
        this.type = type;
    }

    //색이 없는 경우 기본으로 흰색(white)의 말을 생성
    public Color getColor() {
       return color;
    }

    public Type getType(){
        return type;
    }

    // 팩토리 메서드: 색과 타입을 받아 Piece 객체를 생성
    public static Piece createPiece(Color color, Type type) {
        return new Piece(color, type);
    }
}