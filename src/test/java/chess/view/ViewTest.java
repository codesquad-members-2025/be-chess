package chess.view;

import chess.board.Board;
import org.junit.jupiter.api.BeforeEach;


public class ViewTest {

    private Board board;
    private ChessView view;

    @BeforeEach
    void setUp() {
        board = new Board();
        view = new ChessView(board);
    }


}
