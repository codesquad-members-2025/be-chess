package chess;

import chess.pieces.Piece;
import chess.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static chess.pieces.Piece.*;

public class Board {
    private static final int MAX_PIECE_SIZE = 32;
    private static final int FILE_SIZE = 8;
    public static final int RANK_SIZE = 8;
    private final List<Piece> pieces = new ArrayList<>();
    private final List<Rank> board = new ArrayList<>();

    public void initialize() {
        addPieces();
        initializeBoard();
    }

    public void initializeEmpty() {
        Rank emptyRank = new Rank(createEmptyRank());
        for (int rank = 0; rank < RANK_SIZE; rank++) {
            board.add(emptyRank);
        }
    }

    public void move(String position, Piece piece) {
        Position pos = new Position(position);

        Rank rank = board.get(pos.getY());
        Rank updatedRank = rank.updatePiece(pos.getX(), piece);
        board.set(pos.getY(), updatedRank);
    }

    public int pieceCount() {
        return pieces.size();
    }

    public int getSpecificPieceCount(Type type, Color color) {
        int count = 0;
        for (Rank rank : board) {
            for (int file = 0; file < FILE_SIZE; file++) {
                Piece piece = rank.getPiece(file);
                if (piece.getColor().equals(color) && piece.getType().equals(type)) {
                    count++;
                }
            }
        }
        return count;
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (int rank = RANK_SIZE; rank >= 1; rank--) {
            sb.append(StringUtils.appendNewLine(board.get(rank-1).toString()));
        }
        return sb.toString();
    }

    public Piece findPiece(String position) {

        Position pos = new Position(position);
        return board.get(pos.getY()).getPiece(pos.getX());
    }


    private void initializeBoard() {

        board.add(new Rank(createInitialOneRank()));
        board.add(new Rank(createInitialTwoRank()));

        Rank emptyRank = new Rank(createEmptyRank());
        for (int rank = 6; rank > 2; rank--) { // 6~3 랭크
            board.add(emptyRank);
        }

        board.add(new Rank(createInitialSevenRank()));
        board.add(new Rank(createInitialEightRank()));
    }

    private List<Piece> createInitialSevenRank() {
        List<Piece> initialSevenRank = new ArrayList<>();
        for (int file = 0; file < FILE_SIZE; file++) {
            initialSevenRank.add(pieces.get(file));
        }
        return initialSevenRank;
    }

    private List<Piece> createInitialEightRank() {
        List<Piece> initialEightRank = new ArrayList<>();
        for (int file = 0; file < FILE_SIZE; file++) {
            initialEightRank.add(pieces.get(8+file));
        }
        return initialEightRank;
    }
    private List<Piece> createInitialTwoRank() {
        List<Piece> initialTwoRank = new ArrayList<>();
        for (int file = 0; file < FILE_SIZE; file++) {
            initialTwoRank.add(pieces.get(24+file));
        }
        return initialTwoRank;
    }

    private List<Piece> createInitialOneRank() {
        List<Piece> initialOneRank = new ArrayList<>();
        for (int file = 0; file < FILE_SIZE; file++) {
            initialOneRank.add(pieces.get(16 + file));
        }
        return initialOneRank;
    }
    private List<Piece> createEmptyRank() {
        Piece blank = createBlank();
        List<Piece> emptyRank = new ArrayList<>();
        for (int file = 0; file < FILE_SIZE; file++) {
            emptyRank.add(blank);
        }
        return emptyRank;
    }

    private void addPieces() {
        for (int i = 0; i < 8; i++) { // 폰
            add(createBlackPawn());
        }

        add(createBlackRook());
        add(createBlackKnight());
        add(createBlackBishop());
        add(createBlackQueen());
        add(createBlackKing());
        add(createBlackBishop());
        add(createBlackKnight());
        add(createBlackRook());

        add(createWhiteRook());
        add(createWhiteKnight());
        add(createWhiteBishop());
        add(createWhiteQueen());
        add(createWhiteKing());
        add(createWhiteBishop());
        add(createWhiteKnight());
        add(createWhiteRook());

        for (int i = 0; i < 8; i++) { // 폰
            add(createWhitePawn());
        }
    }

    private void add(Piece piece) {
        validatePieceSize();
        pieces.add(piece);
    }

    private void validatePieceSize() {
        if (pieces.size() > MAX_PIECE_SIZE) {
            throw new IllegalStateException("폰은 " + MAX_PIECE_SIZE + "개를 초과할 수 없습니다.");
        }
    }


    public double calculatePoint(Color color) {
        double point = 0.0;
        for (Rank rank : board) {
            for (int file = 0; file < FILE_SIZE; file++) {
                Piece piece = rank.getPiece(file);
                if (piece.getColor().equals(color)) {
                    point += piece.getType().getDefaultPoint();
                }
            }
        }
        return point;
    }
}
