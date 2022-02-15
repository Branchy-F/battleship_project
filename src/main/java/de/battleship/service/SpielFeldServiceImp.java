package de.battleship.service;

import de.battleship.dao.BackendDAO;
import de.battleship.dao.BackendDAOImp;
import de.battleship.gui.AppTest;

import java.util.Arrays;

public class SpielFeldServiceImp implements SpielFeldService {
    private static SpielFeldServiceImp instance;
    private BackendDAO backendDAO;
    private AppTest app;
    private int[][] spielFeldGegner = new int[10][10];
    private int[][] meinSpielFeld = new int[10][10];

    public SpielFeldServiceImp(AppTest app) {
        backendDAO = new BackendDAOImp();
        this.app = app;
    }

    //'x' und 'y' von der GUI erhalten
    public void anfrageAbschicken(int x, int y){
        Zug zug = new Zug(x, y);
        //??? Anfrage abschicken
        Antwort antwort = new Antwort(); //??? Antwort bekommen

        //app.setFeldGegner(feldAendern(zug, antwort, spielFeldGegner));
        //app.setMeldung(meldungFuerGuiErstellen(antwort));
    }

    public void anfrageBekommen(){
        Zug zug = new Zug(0,0); //??? Anfrage bekommen
        Antwort antwort = antwortErstellen(zug);
        //??? Antwort abschicken


        //app.setMeinFeld(feldAendern(zug, antwort, meinSpielFeld));
        //app.setMeldung(meldungFuerGuiErstellen(antwort));
    }

    @Override
    public boolean istValide(int[][] feld) {
        if(backendDAO.istValide(feld, 1,2,3,4)){
            meinSpielFeld = Arrays.stream(feld).map(int[]::clone).toArray(int[][]::new);
            return true;
        }
        return false;
    }

    @Override
    public Antwort antwortErstellen(Zug zug){
        int x = zug.getX();
        int y = zug.getY();
        Antwort antwort = new Antwort();
        if (backendDAO.istGetroffen(x, y)) {
            antwort.setGetroffen(true);
            if (backendDAO.istVersenkt(x,y)) {
                antwort.setVersenkt(true);
                antwort.setKoordinaten(backendDAO.getLetztesVersenktesSchiff());
                if(backendDAO.spielBeendet()) { antwort.setSpielBeendet(true); }
            }
        }
        else{ if (backendDAO.schonMalGeschossen()) { antwort.setSchonMalGeschossen(true); } }
        return antwort;
    }

    @Override
    //'0'-leer, '1'-Schiff, '5' - daneben geschossen, '8'-getroffen, '9'-versenkt
    public int[][] feldAendern(Zug zug, Antwort antwort, int[][] feld){
        int x = zug.getX();
        int y = zug.getY();
        if (antwort.isGetroffen()) {
            feld[x][y] = 8;
            if (antwort.isVersenkt()){
                for (int[] schiffsTeil : antwort.getKoordinaten()){
                    feld[schiffsTeil[0]][schiffsTeil[1]] = 9;
                }
            }
        }
        else{ feld[x][y] = 5; }
        return feld;
    }

    @Override
    public String meldungFuerGuiErstellen(Antwort antwort){
        String meldung = "";
        if (antwort.isGetroffen()) {
            meldung = "Getroffen";
            if (antwort.isVersenkt()){
                meldung = "Versenkt";
                if (antwort.isSpielBeendet()) { meldung = "Das spiel ist beendet"; }
            }
        }
        else{
            meldung = "Daneben";
            if (antwort.isSchonMalGeschossen()) { meldung = "Sinnlos (weil schon mal dorthin geschossen)"; }
        }
        return meldung;
    }
}
