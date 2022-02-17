package de.battleship.service;

public interface SpielFeldService {
    void zugAbschicken(int x, int y);
    void aufAntwortReagieren(Antwort antwort);
    Antwort aufZugReagieren(Zug zug);
    Antwort antwortErstellen(Zug zug);
    int[][] feldAendern(Zug zug, Antwort antwort, int[][] feld);
    String meldungFuerGuiErstellen(Antwort antwort);
    boolean schiffeEintragen();

    int[][] getMeinSpielFeld();
}
