package chess;

import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.appendNewLine;

public class Board {
    private static final int BOARD_SIZE = 8;

    private List<Piece> whitePieces;
    private List<Piece> blackPieces;
    private ArrayList<Rank> board;
    private int piecesIndex;

    public Board() {
        this.board = new ArrayList<>();
        this.piecesIndex = 0;
        this.whitePieces = Piece.createWhite();
        this.blackPieces = Piece.createBlack();
    }

    public int pieceCount() {
        return whitePieces.size() + blackPieces.size();
    }

    public void initialize() {
        setEmptyBoard();
        placePawn();
        placePieces();
    }

    public void setEmptyBoard() {
        for (int i = 0; i < BOARD_SIZE; i++) {
            board.add(new Rank());
        }
    }

    private void placePawn() {
        for (int i = 0; i < BOARD_SIZE; ++i) {
            Piece blackPiece = blackPieces.get(piecesIndex);
            Piece whitePiece = whitePieces.get(piecesIndex);
            board.get(6).addPiece(i, blackPiece);
            board.get(1).addPiece(i, whitePiece);
            ++piecesIndex;
        }
    }

    private void placePieces() {
        for (int i = 0; i < BOARD_SIZE; ++i) {
            board.getFirst().addPiece(i, whitePieces.get(piecesIndex));
            board.getLast().addPiece(i, blackPieces.get(piecesIndex));
            ++piecesIndex;
        }
    }

    public String showBoard() {
        StringBuilder chessBoard = new StringBuilder();
        for (var rowIndex = BOARD_SIZE - 1; rowIndex >= 0; --rowIndex) {
            List<Piece> rank = board.get(rowIndex).getRank();
            StringBuilder row = new StringBuilder();
            for (var columnIndex = 0; columnIndex < BOARD_SIZE; ++columnIndex) {
                Piece piece = rank.get(columnIndex);
                row.append((piece.isBlack()) ?
                    Character.toUpperCase(piece.getType().getRepresentation()) : piece.getType());
            }
            chessBoard.append(appendNewLine(row.toString()));
        }
        return chessBoard.toString();
    }

    public int countPiece(Piece.Color color, Piece.Type type) {
        int count = 0;
        for (Rank rank : board) {
            for (Piece piece : rank.getRank()) {
                if(matches(piece, color, type)) ++count;
            }
        }
        return count;
    }

    private boolean matches(Piece piece, Piece.Color color, Piece.Type type) {
        return piece.getColor() == color &&
            piece.getType().getRepresentation() == type.getRepresentation();
    }

    public Piece searchPiece(Position position) {
        return  board.get(position.getY()).getRank().get(position.getX());
    }

    public void move(Position position, Piece piece) {
        board.get(position.getY()).getRank().set(position.getX(), piece);
    }

    public double calculatePoint(Piece.Color color) {
        double point = 0;

        for (Rank rank : board) {
            ArrayList<Piece> pieces = rank.getRank();
            for (int column = 0; column < BOARD_SIZE; column++) {
                Piece piece = pieces.get(column);
                if (piece.getColor() == color) {
                    if (piece.getType() == Piece.Type.PAWN) { // 폰인 경우 같은 세로줄에 중복되는 폰이 존재하는지 확인
                        if (checkDuplicatedPawn(column)) {
                            point += 0.5; // 중복될 경우 0.5점 부여
                        } else {
                            point += piece.getType().getDefaultPoint();
                        }
                    } else {
                        point += piece.getType().getDefaultPoint();
                    }
                }
            }
        }

        return point;
    }

    private boolean checkDuplicatedPawn(int column) { // 같은 세로줄에 같은 색 중복되는 폰이 있는지 확인
        int pawnCount = 0;

        for (Rank rank : board) {
            ArrayList<Piece> pieces = rank.getRank();
            Piece piece = pieces.get(column);
            if (piece.getType() == Piece.Type.PAWN) ++pawnCount;
        }

       return pawnCount > 1;
    }

}
