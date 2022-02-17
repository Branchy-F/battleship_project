package de.battleship.service;

import de.battleship.gui.BattleshipApp;

public interface SpielFeldService {
    boolean zugAbschicken(int x, int y);
    void aufAntwortReagieren(Antwort antwort);
    Antwort aufZugReagieren(Zug zug);
    Antwort antwortErstellen(Zug zug);
    int[][] feldAendern(Zug zug, Antwort antwort, int[][] feld);
    String meldungFuerGuiErstellen(Antwort antwort);

    void verbindungErstellen();

    BattleshipApp getApp();

    boolean schiffeEintragen();
    int[][] getMeinSpielFeld();
    boolean istValide(int[][] feld);
}
