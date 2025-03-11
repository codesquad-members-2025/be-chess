package chess.springchess;

import chess.game.Board;
import chess.game.ChessGame;
import chess.game.ChessView;
import chess.game.Rank;
import chess.springchess.ChessDto.initGameDto;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessController {
    private final ChessGame chessGame;
    private final Board board;
    private final ChessView chessView;

    public ChessController(ChessGame chessGame, Board board, ChessView chessView) {
        this.chessGame = chessGame;
        this.board = board;
        this.chessView = chessView;
    }

    @GetMapping(value = "/api/start")
    public Result<ChessDto.initGameDto> startGame() {
        board.initialize();
        return Result.onSuccess(ChessConverter.createInitGameDto(chessView.showBoard()), "보드판이 초기화 되었습니다.");
    }

}
