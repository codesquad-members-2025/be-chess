# be-chess

2025 마스터즈 체스 프로젝트

## 주의할 점

- Lucas 컨텐츠의 내용을 공개된 저장소 또는 웹에 올리는 것은 엄격하게 금지합니다.
- 커밋메시지는 한글로 두 줄 이상 작성합니다.
- MVC 패턴은 사용하지 않습니다.

---
## Step2-5
1. 기물의 색, 종류에 따른 enum 구현 (Piece 클래스에 enum 추가)
   * Color enum 추가: WHITE, BLACK, NONCOLOR 
   * Type enum 추가: PAWN, ROOK, KNIHT, BISHOP, QUEEN, KING, NO_PIECE (각 기물의 문자값 포함(소문자))
        * 식별 문자는 소문자로 관리
        * representation 반환 메서드: getWhiteRepresentation(), getBlackRepresentation()
        * Character.tiUpperCase()를 이용해 getBlackRepresentation() 에서는 대문자 반환
   * 기존 상수 제거
       
2. Piece에 대한 색과 기물에 따라 분리된 팩토리 메소드에서 enum 사용
    * 기존 상수 제거하고 enum 사용
    * 기물이 존재하지 않는 Piece도 생성할 수 있도록 Piece.createBlank() 메소드 구현