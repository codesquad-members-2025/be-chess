package chess;

import pieces.Piece;
import static pieces.PieceFactory.*;
import pieces.Piece.Type;
import java.util.ArrayList;


public class Board {
    private final ArrayList<Rank> board = new ArrayList<>();

    private static final int BOARD_SIZE = 8;
    private static final int BLACK_PAWN_ROW = 6;
    private static final int WHITE_PAWN_ROW = 1;
    private static final int WHITE_ROW = 0;
    private static final int BLACK_ROW = 7;


    public Board() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(new Rank());
        }
    }

    public void initializeEmpty() {
        board.clear();
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(new Rank());
        }
    }

    public void initialize() {
        Piece.Type[] pieceOrder = {Type.ROOK, Type.KNIGHT, Type.BISHOP, Type.QUEEN, Type.KING, Type.BISHOP, Type.KNIGHT, Type.ROOK};
        board.clear();

        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(new Rank());  // Rank 객체를 다시 추가 -> clear()를 하면 체스판이 비어버림. 다시 Rank를 추가해줘야함.
        }

        for (int i = 0; i < BOARD_SIZE; i++) {
            board.get(BLACK_PAWN_ROW).setPiece(i, createBlack(Type.PAWN));
            board.get(WHITE_PAWN_ROW).setPiece(i, createWhite(Type.PAWN));
        }


        for (int i = 0; i < BOARD_SIZE; i++) {
            board.get(WHITE_ROW).setPiece(i, createWhite(pieceOrder[i]));
            board.get(BLACK_ROW).setPiece(i, createBlack(pieceOrder[i]));
        }

    }

    public void setPiece(int row, int col, Piece piece) {
        board.get(row).setPiece(col, piece);//  Rank의 setPiece() 호출
    }

    public Piece getPiece(int row, int col){
        return board.get(row).getPiece(col);

    }
    public Rank getRank(int index) {
        return board.get(index);
    }


    public int pieceCount(Piece.Color color, Piece.Type type) {
        return (int) board.stream()
                .flatMap(rank -> rank.getRow().stream())
                .filter(piece -> piece.getColor() == color && piece.getType() == type)
                .count();
    }

    public int totalPieceCount() {
        return (int) board.stream()
                .flatMap(rank -> rank.getRow().stream())
                .filter(piece -> piece.getType() != Type.NO_PIECE)
                .count();
    }


    public void addPiece(String position, Piece piece) {
        Position pos = new Position(position);
        setPiece(pos.getRow(), pos.getCol(), piece);
    }

    public void removePiece(String position) {
        Position pos = new Position(position);
        setPiece(pos.getRow(), pos.getCol(), createBlank());
    }

    public boolean isValidPosition(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        return row >= 0 && row < BOARD_SIZE && col >= 0 && col < BOARD_SIZE;
    }


}


