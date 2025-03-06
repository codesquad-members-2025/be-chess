# be-chess

2025 마스터즈 체스 프로젝트

## 주의할 점

- Lucas 컨텐츠의 내용을 공개된 저장소 또는 웹에 올리는 것은 엄격하게 금지합니다.
- 커밋메시지는 한글로 두 줄 이상 작성합니다.
- MVC 패턴은 사용하지 않습니다.

- 소스 코드는 src 폴더에 있습니다. 
## Feature 1
Pawn 클래스를 만들고, Test 코드 연습해보기.  

## Feature 2 
보드 클래스를 만들어서, Pawn을 추가할 수 있게하고, 패키지 생성  
추가로 Pawn의 색상을 상수로 관리하도록 함. 

## Feature 3
Pawn 색에 따라 출력 문자를 나누었고, 체스판 초기화와 출력 메서드를 작성했다. 

## Feature 4
Pawn 클래스를 Piece 클래스로 바꿔, Pawn 뿐만 아니라 다른 체스 기물들도 다루도록 바꿨다.  
Piece 클래스는 이제 팩토리 메서드로 생성할 수 있게 바꾸었고, 색을 확인할 수 있는 메서드를 추가했다.  
Board 클래스는 원래 Pawn 리스트만 관리했지만, 이젠 다른 Piece들을 다루는 Piece 리스트를 관리한다.  
Board 클래스는 현재의 보드를 출력할 수 있도록 했다.  