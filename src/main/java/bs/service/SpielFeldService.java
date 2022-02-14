package bs.service;

public interface SpielFeldService {
    boolean istValide (int[][] feld);
    boolean istGetroffen (int[] koordinaten);

    // 1 Element ('0' - nicht versenkt, '1' - versenkt), andere Elemente - Koordinaten vom Schiff
    int[] istVersentkt (int[] koordinaten);

    //'0' - spielen weiter, '1' - erster Spieler hat gewonnen, '2' - zweiter Spieler hat gewonnen
    int spielenWeiter();
}
