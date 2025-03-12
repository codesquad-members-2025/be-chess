package chess;

import pieces.*;
import pieces.Piece.*;
import java.util.*;

public class Board {
    private ArrayList<Rank> pieces = new ArrayList<>();

    public void initialize(){
        pieces.clear();
        pieces.add(createBlackRanks());
        pieces.add(createBlackPawns());
        for(int i = 2; i <= 5; i++){
            pieces.add(createBlanks(i));
        }
        pieces.add(createWhitePawns());
        pieces.add(createWhiteRanks());
    }

    public void initializeEmpty(){
        pieces.clear();
        for(int i = 0; i < 8; i++){
            pieces.add(createBlanks(i));
        }
    }

    public Piece findPiece(Position position) {
        return pieces.get(position.getY()).getPiece(position.getX());
    }

    private Rank createBlackRanks(){
        return createRanks(Color.BLACK, 8);
    }

    private Rank createWhiteRanks(){
        return createRanks(Color.WHITE, 1);
    }

    public Rank createWhitePawns(){
        return createPawns(Color.WHITE, 2);
    }

    private Rank createBlackPawns(){
        return createPawns(Color.BLACK, 7);
    }

    private Rank createRanks(Color color, int col){
        ArrayList<Piece> horses = new ArrayList<>();
        String colNum = String.valueOf(col);
        horses.add(Piece.create(Type.ROOK, color, new Position("a"+colNum)));
        horses.add(Piece.create(Type.KNIGHT, color, new Position("b"+colNum)));
        horses.add(Piece.create(Type.BISHOP, color, new Position("c"+colNum)));
        horses.add(Piece.create(Type.QUEEN, color, new Position("d"+colNum)));
        horses.add(Piece.create(Type.KING, color, new Position("e"+colNum)));
        horses.add(Piece.create(Type.BISHOP, color, new Position("f"+colNum)));
        horses.add(Piece.create(Type.KNIGHT, color, new Position("g"+colNum)));
        horses.add(Piece.create(Type.ROOK, color, new Position("h"+colNum)));
        return new Rank(horses);
    }

    public Rank createPawns(Color color, int row) {
        ArrayList<Piece> pawns = new ArrayList<>();
        for (int i = 97; i < 105; i++) {
            String position = (char) i + String.valueOf(row);
            pawns.add(Piece.create(Type.PAWN, color, new Position(position)));
        }
        return new Rank(pawns);
    }

    private Rank createBlanks(int row){
        ArrayList<Piece> blanks = new ArrayList<>();
        for (int i = 97; i < 105; i++){
            String position = (char) i + String.valueOf(row);
            blanks.add(Blank.createBlank(new Position(position)));
        }
        return new Rank(blanks);
    }

    public ArrayList<Rank> getPieces(){
        return pieces;
    }
}