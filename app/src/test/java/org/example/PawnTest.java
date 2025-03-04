package org.example;
import org.junit.jupiter.api.*;
import static org.assertj.core.api.Assertions.*;

public class PawnTest {

    @Test
    @DisplayName("흰색 폰이 생성되어야 한다")
    public void create() {
        Pawn pawn = new Pawn("white");
        assertThat(pawn.getColor()).isEqualTo("white");
    }

    // brew로 Gradle을 설치한 후, 작업 디렉토리에서 gradle init을 실행하여 Gradle 프로젝트 설정.
    // build.gradle에 assertj 의존성 추가하여 테스트 코드 실패하는 것 확인.
}