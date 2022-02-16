package de.battleship.service;

public interface SpielFeldService {
    //'x' und 'y' von der GUI erhalten
    boolean zugAbschicken(int x, int y);

    void aufAntwortReagieren(Antwort antwort);

    void setMeldungVerbindung(String meldung);

    Antwort aufZugReagieren(Zug zug);
    boolean istValide (int[][] feld);
    Antwort antwortErstellen(Zug zug);
    int[][] feldAendern(Zug zug, Antwort antwort, int[][] feld);
    String meldungFuerGuiErstellen(Antwort antwort);

}
