package de.battleship.service;

public interface SpielFeldService {
    boolean zugAbschicken(int x, int y);
    boolean aufAntwortReagieren(Antwort antwort);
    Antwort aufZugReagieren(Zug zug);
    Antwort antwortErstellen(Zug zug);
    int[][] feldAendern(Zug zug, Antwort antwort, int[][] feld);
    String meldungFuerGuiErstellen(Antwort antwort);
    boolean schiffeEintragen();
    boolean istValide(int[][] feld);
}
