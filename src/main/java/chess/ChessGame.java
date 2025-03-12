package chess;

import chess.board.Board;
import chess.config.ChessConfig;
import chess.controller.ChessController;
import chess.enums.Color;
import chess.game.Game;
import chess.view.ChessView;

import java.util.Scanner;

import static chess.enums.Color.WHITE;

public class ChessGame {

    public static void main(String[] args) {
        ChessController controller =new ChessConfig().chessController();
        controller.run();
    }
}

