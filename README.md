# be-chess

2025 마스터즈 체스 프로젝트

## 주의할 점

- Lucas 컨텐츠의 내용을 공개된 저장소 또는 웹에 올리는 것은 엄격하게 금지합니다.
- 커밋메시지는 한글로 두 줄 이상 작성합니다.
- MVC 패턴은 사용하지 않습니다.


### 1단계
**설계의도**
- Junit을 이용해 테스트를 진행한다.
- @DisplayName을 이용해 각 테스트를 명확하게 한다.
- Pawn클래스는 색상을 생성자 매개변수로 받는다.

**실수**
- Junit설정을 했지만 Test클래스에서 import가 되지 않는 문제,
  testImplementation으로 의존성을 설정했는데 클래스 경로를 test가 아닌 main에 만들어서 발생했다.
 테스트 클래스를 test/java로 이동시켜 해결
