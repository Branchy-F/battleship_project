package bs.dao;

public class BackendDAOImp implements BackendDAO{
    private static BackendDAOImp instance = null;

    private BackendDAOImp() {
    }

    public static BackendDAOImp getInstance(){
        if (instance == null) { instance = new BackendDAOImp(); }
        return instance;
    }

    @Override
    public boolean istValide(int[][] feld) {
        return false;
    }

    @Override
    public boolean istGetroffen(int[] koordinaten) {
        return false;
    }

    @Override
    public int[] istVersentkt(int[] koordinaten) {
        return new int[0];
    }

    @Override
    public int spielenWeiter() {
        return 0;
    }
}
