package de.battleship.service;

public interface SpielFeldService {
    boolean istValide (int[][] feld);
    Antwort antwortErstellen(Zug zug);
    int[][] feldAendern(Zug zug, Antwort antwort, int[][] feld);
    String meldungFuerGuiErstellen(Antwort antwort);
}
