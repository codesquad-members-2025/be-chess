package chess.piece;

public abstract class Piece {

    public enum Color {
        WHITE, BLACK
    }

    private final Color color;
    private final String name;

    private Piece(Color color, String name) {
        this.color = color;
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public boolean isBlack() {
        return color == Color.BLACK;
    }

    public boolean isWhite() {
        return color == Color.WHITE;
    }

    // ===== White 기물 (소문자) =====
    public static Piece createWhitePawn() {
        return new Piece(Color.WHITE, "Pawn") {
            @Override
            public char getSymbol() {
                return 'p';
            }
        };
    }

    public static Piece createWhiteRook() {
        return new Piece(Color.WHITE, "Rook") {
            @Override
            public char getSymbol() {
                return 'r';
            }
        };
    }

    public static Piece createWhiteKnight() {
        return new Piece(Color.WHITE, "Knight") {
            @Override
            public char getSymbol() {
                return 'n';
            }
        };
    }

    public static Piece createWhiteBishop() {
        return new Piece(Color.WHITE, "Bishop") {
            @Override
            public char getSymbol() {
                return 'b';
            }
        };
    }

    public static Piece createWhiteQueen() {
        return new Piece(Color.WHITE, "Queen") {
            @Override
            public char getSymbol() {
                return 'q';
            }
        };
    }

    public static Piece createWhiteKing() {
        return new Piece(Color.WHITE, "King") {
            @Override
            public char getSymbol() {
                return 'k';
            }
        };
    }

    // ===== Black 기물 (대문자) =====
    public static Piece createBlackPawn() {
        return new Piece(Color.BLACK, "Pawn") {
            @Override
            public char getSymbol() {
                return 'P';
            }
        };
    }

    public static Piece createBlackRook() {
        return new Piece(Color.BLACK, "Rook") {
            @Override
            public char getSymbol() {
                return 'R';
            }
        };
    }

    public static Piece createBlackKnight() {
        return new Piece(Color.BLACK, "Knight") {
            @Override
            public char getSymbol() {
                return 'N';
            }
        };
    }

    public static Piece createBlackBishop() {
        return new Piece(Color.BLACK, "Bishop") {
            @Override
            public char getSymbol() {
                return 'B';
            }
        };
    }

    public static Piece createBlackQueen() {
        return new Piece(Color.BLACK, "Queen") {
            @Override
            public char getSymbol() {
                return 'Q';
            }
        };
    }

    public static Piece createBlackKing() {
        return new Piece(Color.BLACK, "King") {
            @Override
            public char getSymbol() {
                return 'K';
            }
        };
    }

    // 기물의 표시 문자 반환 (각 기물마다 다름)
    public abstract char getSymbol();
}
