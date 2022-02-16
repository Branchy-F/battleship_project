package de.battleship.service;

import de.battleship.dao.BackendDAO;
import de.battleship.dao.BackendDAOImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTest {
    static int[][] testFeld = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                               {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                               {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                               {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                               {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                               {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                               {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                               {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                               {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    static SpielFeldService spielFeldService = new SpielFeldServiceImp();
    BSSocket bs;
    BackendDAO backendDAO  = new BackendDAO() {

        @Override
        public boolean istValide(int[][] feld, int anzahlBattleship, int anzahlCruiser, int anzahlDestroyer, int anzahlSubmarine) {
            return false;
        }

        @Override
        public boolean istGetroffen(int x, int y) {
            return false;
        }

        @Override
        public boolean schonMalGeschossen() {
            return false;
        }

        @Override
        public boolean istVersenkt(int x, int y) {
            return false;
        }

        @Override
        public boolean spielBeendet() {
            return false;
        }

        @Override
        public List<int[]> getLetztesVersenktesSchiff() {
            return null;
        }

        @Override
        public void setFeld(int[][] feld) {

        }

        @Override
        public List<List<int[]>> getSchiffe() {
            return null;
        }

        @Test
        void testValide() {
            boolean check = spielFeldService.istValide(testFeld);
            assertTrue(check);
        }
    };


    @Test
    void testZugAbschicken () throws IOException {
        int x = 0;
        int y = 0;
        Zug zug = new Zug (x,y);
        bs = new BSSocket(spielFeldService,"localhost", 22000, 22001);
        boolean checkAbschicken = spielFeldService.zugAbschicken(x,y);
        assertTrue(checkAbschicken);
    }

    @Test
    void testAntwortErstellen(Zug zug)
    {
        int x = zug.getX();
        int y = zug.getY();
        Antwort antwort = new Antwort();
        boolean checkAntwortErstellen(spielFeldService.antwortErstellen());
        if (backendDAO.istGetroffen(x,y))
        {
            antwort.setGetroffen(true);
            assertTrue(checkAntwortErstellen);
        }
        if (backendDAO.istVersenkt(x,y))
        {
            antwort.setVersenkt(true);
            assertTrue(checkAntwortErstellen);
            antwort.setKoordinaten(backendDAO.getLetztesVersenktesSchiff());
        }
        if (backendDAO.spielBeendet())
        {
            antwort.setSpielBeendet(true);
        }
    }

}

