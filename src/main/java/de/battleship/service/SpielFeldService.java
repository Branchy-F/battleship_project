package de.battleship.service;

public interface SpielFeldService {
    boolean istValide (int[][] feld);
    boolean istGetroffen(int x, int y);
}
