package bs.service;

import bs.dao.Antwort;
import bs.dao.BackendDAOImp;

import java.lang.reflect.AnnotatedType;
import java.util.Arrays;

public class SpielFeldServiceImp implements SpielFeldService {
    private static SpielFeldServiceImp instance;
    private final BackendDAOImp backendDAOImp;

    public static SpielFeldServiceImp getInstance(){
        if (instance == null) { instance = new SpielFeldServiceImp(); }
        return instance;
    }

    public SpielFeldServiceImp() { backendDAOImp = BackendDAOImp.getInstance(); }

    @Override
    public boolean istValide(int[][] feld) {
        return backendDAOImp.istValide(feld, 1,2,3,4);
    }

    @Override
    public boolean istGetroffen(int x, int y) {
//        Antwort antwort = backendDAOImp.istGetroffen(x, y);
        return false;
    }
}
