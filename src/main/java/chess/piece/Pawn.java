package chess.piece;

public class Pawn extends Piece {

    public Pawn(Color color){
        super(color);
    }

    @Override
    public char getSymbol() {
        if(getColor()==Color.WHITE){
            return 'p';
        } else  {
            return  'P';
        }
    }


    public Pawn() {
        super(Piece.Color.WHITE);
    }


}

