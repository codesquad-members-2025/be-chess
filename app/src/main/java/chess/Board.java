package chess;

import pieces.*;
import pieces.Piece.*;
import java.util.*;
import static utils.StringUtils.appendNewLine;

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

    public Piece findPiece(String position) {
        Position pos = new Position(position);
        return pieces.get(pos.getY()).getPiece(pos.getX());
    }

    private Rank createBlackRanks(){
        return createRanks(Color.BLACK, 8);
    }

    private Rank createWhiteRanks(){
        return createRanks(Color.WHITE, 0);
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

//    public void initializeEmpty(){
//        pieces.clear();
//        for(int i = 0; i<8; i++){
//            pieces.add(createBlank());
//        }
//    }

    public void move(String sourcePosition, String targetPosition){
        Position sorce = new Position(sourcePosition);
        Position target = new Position(targetPosition);
        pieces.get(target.getY()).setPiece(target.getX(), findPiece(sourcePosition));
        pieces.get(sorce.getY()).setPiece(sorce.getX(), Blank.createBlank(new Position(sourcePosition)));
    }

    public String showBoard(){
        StringBuilder answer = new StringBuilder();

        for (Rank rank : pieces){
            answer.append(appendNewLine(rank.toString()));
        }

        return answer.toString();
    }

//    public double caculcatePoint(Color color){
//        double score = 0.0;
//        for (Rank rank : pieces){
//            for(int i = 0; i < 8; i++){
//                Piece piece = rank.getPiece(i);
//                if (piece.getType() != Type.NO_PIECE && piece.getColor() == color){
//                    score += piece.getType().getdefaultPoint();
//                }
//            }
//        }
//        return score;
//    }

//    public ArrayList<Piece> sortByScore(Color color, boolean ascending){
//        ArrayList<Piece> pieceList = new ArrayList<>();
//        for (Rank rank : pieces){
//            for(int i = 0; i < 8; i++){
//                Piece piece = rank.getPiece(i);
//                if (piece.getType() != Type.NO_PIECE && piece.getColor() == color){
//                    pieceList.add(piece);
//                }
//            }
//        }
//        pieceList.sort(Comparator.comparing(p -> ascending ? p.getType().getdefaultPoint() : -p.getType().getdefaultPoint()));
//        return pieceList;
//    }
}