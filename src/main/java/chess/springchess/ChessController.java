package chess.springchess;

import chess.game.Board;
import chess.game.ChessGame;
import chess.game.ChessView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChessController {
    private static final String INIT_BOARD = "보드판이 초기화 되었습니다.";
    private static final String MOVE_PIECE_SUCCESS = "기물이 정상적으로 이동하였습니다.";
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
        return Result.onSuccess(ChessConverter.createInitGameDto(chessView.showBoard()), INIT_BOARD);
    }

    @PostMapping("api/move")
    public Result<ChessDto.movePieceDto> movePiece(@RequestBody ChessDto.movePieceDto request) {
        try {
            chessGame.move(request.getStartPos(), request.getEndPos());
            return Result.onSuccess(ChessConverter.createmovePieceDto(request.getStartPos(), request.getEndPos()), MOVE_PIECE_SUCCESS);
        } catch (IllegalArgumentException e) {
            // 예외가 발생하면 Result 객체로 에러 메시지 반환
            return Result.onFailure(request, e.getMessage());
        }
    }

}
