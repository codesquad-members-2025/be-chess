package chess.view;

import chess.board.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static chess.util.StringUtils.appendNewLine;
import static org.assertj.core.api.Assertions.assertThat;


public class ViewTest {

    private Board board;
    private ChessView view;

    @BeforeEach
    void setUp() {
        board = new Board();
        view = new ChessView(board);
    }


}
