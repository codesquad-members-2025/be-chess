package chess.controller;

import chess.board.Board;
import chess.enums.Color;
import chess.game.Game;
import chess.view.ChessView;

import static chess.enums.Color.WHITE;

public class ChessController {

    private final ChessView view;
    private final Board board;
    private final Game game;
    private Color currentTurn = WHITE;
    private boolean isRunning = true; // 게임 실행 상태 관리

    public ChessController(ChessView view, Board board, Game game) {
        this.view = view;
        this.board = board;
        this.game = game;
    }

    public void run() {
        while (isRunning) {
            String userRequest = view.requestUserInput(currentTurn);
            processCommand(userRequest);
        }
    }

    private void processCommand(String userRequest) {
        switch (userRequest) {
            case "start":
                view.printBoard(board.getBoard());
                break;
            case "end":
                isRunning = false; // 게임 종료 플래그 설정
                break;
            default:
                if (userRequest.startsWith("move")) {
                    handleMoveCommand(userRequest);
                } else {
                    view.displayError("⚠️ 잘못된 명령어입니다.");
                }
        }
    }

    private void handleMoveCommand(String command) {
        String[] split = command.split(" ");

        if (split.length != 3) {
            view.displayError("⚠️ 잘못된 명령어입니다. 예시: move b2 b3");
            return;
        }

        String sourceLocation = split[1];
        String targetLocation = split[2];

        if (!game.isValidTurn(sourceLocation, currentTurn)) {
            view.displayError("⚠️ 잘못된 이동입니다. 본인의 기물만 이동할 수 있습니다.");
            return;
        }

        try {
            game.move(sourceLocation, targetLocation);
            view.printBoard(board.getBoard());
            switchTurn();
        } catch (IllegalArgumentException e) {
            view.displayError("⚠️ " + e.getMessage());
        }
    }

    private void switchTurn() {
        currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }
}
