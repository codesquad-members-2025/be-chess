import pieces.Pawn;
import pieces.Piece;

import java.util.ArrayList;
import java.util.List;

public class Board {

    //    private final Piece[][] CHESS_BOARD = new Piece[8][8];
    private final List<Piece> board = new ArrayList<>();

    public void add(Piece piece) {
        board.add(piece);
    }

    public int size() {
        return board.size();
    }

    // count 번째로 들어가 있는 Pawn 의 색 반환
    public String findPawn(int index) {
        String answer = "";
        int count = 0;
        while (count <= index) {
            for (Piece piece : board) {
                if (piece instanceof Pawn) {
                    answer = piece.getColor();
                    count++;
                }
            }
        }
        return answer;
    }

}
