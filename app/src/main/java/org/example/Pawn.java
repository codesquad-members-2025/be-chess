package org.example;

public class Pawn {

    public static final String BLACK = "black";
    public static final String WHITE = "white";

    private final String color;

    public Pawn(String color) {
        this.color = color;
    }
    public Pawn() {
        this.color = WHITE;
    }
    public String getColor() {
        return color;
    }

    // 생성자로 객체를 생성할 때만 색상을 지정하도록 강제하였고 값이 변하지 않게 final을 붙임. 다음으로 color에 대한 getter 생성

}
