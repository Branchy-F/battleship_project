package bs.service;

import bs.dao.BackendDAOImp;

public class SpielFeldServiceImp implements SpielFeldService {
    private static SpielFeldServiceImp instance;
    private BackendDAOImp backendDAOImp;

    public static SpielFeldServiceImp getInstance(){
        if (instance == null) { instance = new SpielFeldServiceImp(); }
        return instance;
    }

    public SpielFeldServiceImp() { backendDAOImp = BackendDAOImp.getInstance(); }

    @Override
    public boolean istValide(int[][] feld) {
        return backendDAOImp.istValide(feld);
    }

    @Override
    public boolean istGetroffen(int[] koordinaten) {
        return false;
    }

    @Override
    public int[] istVersenkt(int[] koordinaten) {
        return null;
    }

    @Override
    public int spielenWeiter() {
        return 0;
    }
}
