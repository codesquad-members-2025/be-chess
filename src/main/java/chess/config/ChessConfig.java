package chess.config;

import chess.board.Board;
import chess.controller.ChessController;
import chess.game.Game;
import chess.view.ChessView;

public class ChessConfig {

    public ChessController chessController(){
        return new ChessController(view(),board(),game());
    }

    private Board board(){
        return new Board();
    }

    private Game game(){
        return new Game(board());
    }

    private ChessView view(){
        return new ChessView();
    }
}
