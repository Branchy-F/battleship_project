package bs.dao;

public interface BackendDAO {
    boolean istValide (int[][] feld);
    Antwort istGetroffen (int x, int y);
}
