package bs.dao;

import java.util.List;

public interface BackendDAO {
    boolean istValide(int[][] feld, int anzahlBattleship, int anzahlCruiser, int anzahlDestroyer, int anzahlSubmarine);
    boolean istGetroffen (int x, int y);
    boolean schonMalGeschossen();
    boolean istVersenkt(int x, int y);
    boolean spielBeendet();
    List<int[]> getLetztesVersenktesSchiff();
}
