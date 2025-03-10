package chess;

import pieces.Piece;
import pieces.Piece.Type;

public class ScoreCalculator {
    private final Board board;

    public ScoreCalculator(Board board) {
        this.board = board;
    }

    public double calculatePoint(Piece.Color color) {
        double totalScore = 0.0;
        int[] pawnScores = new int[8];

        for (int row = 0; row < 8; row++) {  // 세로줄(column) 기준으로 반복
            for (int col = 0; col < 8; col++) {  // 가로줄(row) 순회
                Piece piece = board.getRank(row).getPiece(col);

                if (piece.getColor() == color) {  // 해당 색상의 기물인 경우만 계산
                    if (piece.getType() == Type.PAWN) {
                        pawnScores[col]++;  // 해당 column에서 Pawn 개수 증가
                    } else {
                        totalScore += piece.getType().getDefaultPoint();  // Pawn이 아니면 기본 점수 추가
                    }
                }
            }
        }
        //Pawn 점수 -> 같은 세로줄이면 0.5점으로 계산
        for (int cnt : pawnScores) {
            if (cnt > 1) {
                totalScore += cnt * 0.5;  // 같은 column에 있는 경우 0.5점씩 추가
            } else {
                totalScore += cnt * 1.0;  // 단독으로 있는 경우 1.0점 추가
            }
        }
        return totalScore;
    }

}
