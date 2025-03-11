package chess;

public class Piece { //Pawn 클래스 이름을 Piece로 rename

    public static final String BLACK_COLOR = "black";
    public static final String WHITE_COLOR = "white";
    //Pawn 색에 따른 출력 문자 부여
    public static final char WHITE_PAWN_REPRESENTATION = 'p';
    public static final char BLACK_PAWN_REPRESENTATION = 'P';
    public static final char WHITE_KNIGHT_REPRESENTATION = 'n';
    public static final char BLACK_KNIGHT_REPRESENTATION = 'N';
    public static final char WHITE_ROOK_REPRESENTATION = 'r';
    public static final char BLACK_ROOK_REPRESENTATION = 'R';
    public static final char WHITE_BISHOP_REPRESENTATION ='b';
    public static final char BLACK_BISHOP_REPRESENTATION ='B';
    public static final char WHITE_QUEEN_REPRESENTATION ='q' ;
    public static final char BLACK_QUEEN_REPRESENTATION ='Q' ;
    public static final char WHITE_KING_REPRESENTATION = 'k';
    public static final char BLACK_KING_REPRESENTATION = 'K';


    private final Type type;
    private final Color color;


    public Piece(Color color, Type type) {
        this.color= color;
        this.type = type;
    }

    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE_PAWN, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK_PAWN, Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE_KNIGHT, Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK_KNIGHT, Type.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE_ROOK, Type.ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK_ROOK, Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE_BISHOP, Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK_BISHOP, Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE_QUEEN, Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK_QUEEN, Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE_KING, Type.KING);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK_KING, Type.KING);
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

    public boolean isBlack() {
        return this.getColor().getColorName().equals(BLACK_COLOR);
    }

    public boolean isWhite() {
        return this.getColor().getColorName().equals(WHITE_COLOR);
    }

    //검은색 말과 흰색 말을 구분할 수 있는 메소드 추가


}