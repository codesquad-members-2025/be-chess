package org.example;

public class Pawn {
    String color;

    public static final String BLACK = "black";
    public static final String WHITE = "white";

    public Pawn(String color) {
        this.color=color;
    }
    public Pawn(){
        this.color="white";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
