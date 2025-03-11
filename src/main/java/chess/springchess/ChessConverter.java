package chess.springchess;

import chess.springchess.ChessDto.initGameDto;

public class ChessConverter {
    public static ChessDto.initGameDto createInitGameDto(String board) {
        return new initGameDto(board);
    }
}
