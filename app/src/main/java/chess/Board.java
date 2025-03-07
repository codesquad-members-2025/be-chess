package chess;

import pieces.*;
import pieces.Piece.*;
import java.util.*;
import static utils.StringUtils.appendNewLine;

public class Board {
    private ArrayList<Rank> pieces = new ArrayList<>();


    public void initialize(){
        pieces.clear();
        pieces.add(createBlackRank());
        pieces.add(createBlackPawn());
        for(int i = 0; i<4; i++){
            pieces.add(createBlank());
        }
        pieces.add(createWhitePawn());
        pieces.add(createWhiteRank());
    }

    public Piece findPiece(String position){
        //piece 객체잡고 리턴해주면 될듯
        int x = position.charAt(0) - 'a';
        int y = 8 - (position.charAt(1) - '0');
        return pieces.get(y).getPiece(x);
    }

    private Rank createBlackRank(){
        ArrayList<Piece> horses = new ArrayList<>();
        horses.add(Piece.createBlackRook());
        horses.add(Piece.createBlackKnight());
        horses.add(Piece.createBlackBishop());
        horses.add(Piece.createBlackQueen());
        horses.add(Piece.createBlackKing());
        horses.add(Piece.createBlackBishop());
        horses.add(Piece.createBlackKnight());
        horses.add(Piece.createBlackRook());
        return new Rank(horses);
    }

    private Rank createWhiteRank(){
        ArrayList<Piece> horses = new ArrayList<>();
        horses.add(Piece.createWhiteRook());
        horses.add(Piece.createWhiteKnight());
        horses.add(Piece.createWhiteBishop());
        horses.add(Piece.createWhiteQueen());
        horses.add(Piece.createWhiteKing());
        horses.add(Piece.createWhiteBishop());
        horses.add(Piece.createWhiteKnight());
        horses.add(Piece.createWhiteRook());
        return new Rank(horses);
    }

    private Rank createWhitePawn(){
        ArrayList<Piece> pawns = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            pawns.add(Piece.createWhitePawn());
        }
        return new Rank(pawns);
    }

    private Rank createBlackPawn(){
        ArrayList<Piece> pawns = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            pawns.add(Piece.createBlackPawn());
        }
        return new Rank(pawns);
    }

    private Rank createBlank(){
        ArrayList<Piece> blanks = new ArrayList<>();
        for (int i = 0; i < 8; i++){
            blanks.add(Piece.createBlank());
        }
        return new Rank(blanks);
    }

    public void initializeEmpty(){
        pieces.clear();
        for(int i = 0; i<8; i++){
            pieces.add(createBlank());
        }
    }

    public void move(String position, Piece piece){
        int x = position.charAt(0) - 'a';
        int y = 8 - (position.charAt(1) - '0');
        pieces.get(y).setPiece(x, piece);
    }

    public String showBoard(){
        StringBuilder answer = new StringBuilder();

        for (Rank rank : pieces){
            answer.append(appendNewLine(rank.toString()));
        }

        return answer.toString();
    }

    public double caculcatePoint(Color color){
        double score = 0.0;
        for (Rank rank : pieces){
            for(int i = 0; i < 8; i++){
                Piece piece = rank.getPiece(i);
                if (piece.getType() != Type.NO_PIECE && piece.getColor() == color){
                    score += piece.getType().getdefaultPoint();
                }
            }
        }
        return score;
    }

    public ArrayList<Piece> sortByScore(Color color, boolean ascending){
        ArrayList<Piece> pieceList = new ArrayList<>();
        for (Rank rank : pieces){
            for(int i = 0; i < 8; i++){
                Piece piece = rank.getPiece(i);
                if (piece.getType() != Type.NO_PIECE && piece.getColor() == color){
                    pieceList.add(piece);
                }
            }
        }
        pieceList.sort(Comparator.comparing(p -> ascending ? p.getType().getdefaultPoint() : -p.getType().getdefaultPoint()));
        return pieceList;
    }
}