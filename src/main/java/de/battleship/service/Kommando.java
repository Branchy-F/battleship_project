package de.battleship.service;

import java.io.Serializable;

public class Kommando implements Serializable {
    private String kommando;
    private int x;
    private int y;

    public Kommando(String kommando, int x, int y) {
        this.kommando = kommando;
        this.x = x;
        this.y = y;
    }

    public String getKommando() {
        return kommando;
    }

    public void setKommando(String kommando) {
        this.kommando = kommando;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Kommando{" +
                "kommando='" + kommando + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
