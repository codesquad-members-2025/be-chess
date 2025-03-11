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

    public enum Color{
        WHITE("white"), BLACK("black"), NOCOLOR("");

        private final String value; // 색상 문자열 저장

        Color(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public enum Type {
        PAWN('p'), ROOK('r'), KNIGHT('n'), BISHOP('b'), QUEEN('q'), KING('k'), NO_PIECE(' ');

        private final char representation;

        Type(char representation) {
            this.representation = representation;
        }

        //블랙 -> 대문자 representation, 화이트 -> 소문자 representation
        public char getWhiteRepresentation() {
            return this.representation;
        }

        public char getBlackRepresentation() {
            return Character.toUpperCase(this.representation);
        }

        public char getRepresentation(Color color){
            if(color.equals(Color.BLACK)) return Character.toUpperCase(this.representation);
            else return this.representation;
        }

    }

    private final Type type;
    private final Color color;


    public Piece(Color color, Type type) {
        this.color= color;
        this.type = type;
    }
    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, Type.PAWN);
    }

    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, Type.PAWN);
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, Type.KNIGHT);
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, Type.KNIGHT);
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, Type.ROOK);
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, Type.ROOK);
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, Type.BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, Type.BISHOP);
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, Type.QUEEN);
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, Type.QUEEN);
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, Type.KING);
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, Type.KING);
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
        return this.getColor().equals(Color.BLACK);
    }

    public boolean isWhite() {
        return this.getColor().equals(Color.WHITE);
    }

    public char getRepresentation(){
       if(this.color.equals(Color.BLACK)) return type.getBlackRepresentation();
       else return type.getWhiteRepresentation();
    }

    public static Piece createBlank() {
        return new Piece(Color.NOCOLOR, Type.NO_PIECE);
    }

    //펙토리 메소드 리펙토링
    private  Piece createWhite(Type type){
        return new Piece(Color.WHITE, type);
    }

    private Piece createBlack(Type type){
        return new Piece(Color.BLACK, type);
    }
}