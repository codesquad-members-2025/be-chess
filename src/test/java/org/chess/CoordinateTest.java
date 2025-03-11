package org.chess;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.*;

public class CoordinateTest {

    @Test
    @DisplayName("String으로 좌표가 생성되어야 한다.")
    void make_coordinate_by_string(){
        Coordinate coord = new Coordinate("a3");
        assertThat(coord).isEqualTo(new Coordinate(0,2));
    }

    @Test
    @DisplayName("잘못된 String 양식으로 좌표를 생성하면 IllegalArgumentException 오류를 발생시켜야 한다.(잘못된 size)")
    void make_coordinate_by_string_error1(){
        assertThatThrownBy(() -> new Coordinate("a33"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 String 양식으로 좌표를 생성하면 IllegalArgumentException 오류를 발생시켜야 한다.(잘못된 양식)")
    void make_coordinate_by_string_error2(){
        assertThatThrownBy(() -> new Coordinate("3b"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
