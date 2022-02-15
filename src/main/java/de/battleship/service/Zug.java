package de.battleship.service;

import java.io.Serializable;

public class Zug implements Serializable {
    private final int x;
    private final int y;

    public Zug(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Zug{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
