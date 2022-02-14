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
        Validator validator = new Validator(1,2,3,4);
        return validator.fieldValidator(feld);
    }

    @Override
    public Antwort istGetroffen(int x, int y) {
        return null;
    }

}
