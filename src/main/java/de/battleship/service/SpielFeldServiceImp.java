package de.battleship.service;

import de.battleship.dao.BackendDAO;
import de.battleship.dao.BackendDAOImp;
import de.battleship.gui.SchiffeEintragenController;

import java.io.IOException;
import java.util.Arrays;

public class SpielFeldServiceImp implements SpielFeldService {
    private final BackendDAO backendDAO;
    private SchiffeEintragenController app;
    private int[][] spielFeldGegner = new int[10][10];
    private int[][] meinSpielFeld = new int[10][10];
    BSSocket bs;

    public SpielFeldServiceImp(SchiffeEintragenController app) {
        backendDAO = new BackendDAOImp();
        this.app = app;
//        try {
//            bs = new BSSocket(this,"192.168.1.10", 22000, 22001);
////            bs = new BSSocket(this, "192.168.1.11", 22001, 22000);
//        } catch (IOException e) { e.printStackTrace(); }
    }

    @Override
    public boolean schiffeEintragen() {
        if (backendDAO.istValide(app.getFeld(),1,2,3,4)){
            app.setMeldung("Alle Schiffe wurden richtig eingetragen!");
            meinSpielFeld = Arrays.stream(app.getFeld()).map(int[]::clone).toArray(int[][]::new);
            return true;
        } else {
            int[] anzahlSchiffe = backendDAO.getAnzahlSchiffe(app.getFeld(), 1,2,3,4);

            if (anzahlSchiffe[0] == -1){ //Warnung von Validator
                app.setMeldung("Ein Schiff wurde\nfalsch eingetragen!");
                return false;
            }
            else{
                StringBuilder stringBuilder = new StringBuilder("Schiffe eintragen:");
                String[] schiffe = {"U-Boote", "Zerstörer", "Kreuzer", "Schlachtschiff"};
                for(int i = 0, j=4; i <= 3; i++, j--){
                    if (anzahlSchiffe[i] < i+1) {
                        stringBuilder.append(String.format("\n %d %s (%d Kästchen)", (i+1)-anzahlSchiffe[i], schiffe[j-1], j));
                    } else if (anzahlSchiffe[i] > i+1) {
                        stringBuilder.append(String.format("\n Zu viele %d-Kästchen-Schiffe!", j));
                    }
                }
                app.setMeldung(stringBuilder.toString());
                return false;
            }
        }
    }

    @Override
    //'x' und 'y' von der GUI erhalten
    public void zugAbschicken(int x, int y){
        Zug zug = new Zug(x, y);
        try {
            bs.sendeZug(zug);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void aufAntwortReagieren(Antwort antwort){
        //app.setFeldGegner(feldAendern(zug, antwort, spielFeldGegner));
        //app.setMeldung(meldungFuerGuiErstellen(antwort));
    }

    @Override
    public Antwort aufZugReagieren(Zug zug){
        Antwort antwort = antwortErstellen(zug);
        //app.setMeinFeld(feldAendern(zug, antwort, meinSpielFeld));
        //app.setMeldung(meldungFuerGuiErstellen(antwort));
        return antwort;
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
