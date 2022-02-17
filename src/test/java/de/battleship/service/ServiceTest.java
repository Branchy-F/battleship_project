package de.battleship.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @BeforeEach
    void init() {
        spielFeldService.istValide(testFeld);
    }

    @Test
    void testZugAbschicken() throws IOException {
        int x = 0;
        int y = 0;
        Zug zug = new Zug(x, y);
        bs = new BSSocket(spielFeldService, "localhost", 22000, 22001);
        boolean checkAbschicken = spielFeldService.zugAbschicken(x, y);
        assertTrue(checkAbschicken);
    }

    @Test
    void testAntwortErstellenGetroffen() {
        Zug zug = new Zug(0, 0);

        Antwort antwort = spielFeldService.antwortErstellen(zug);
        assertTrue(antwort.isGetroffen());
    }

    @Test
    void testAntwortErstellenVersenkt() {
        Zug zug = new Zug(8, 7);

        Antwort antwort = spielFeldService.antwortErstellen(zug);
        assertTrue(antwort.isVersenkt());
    }

    @Test
    void testAntwortErstellenSchonGetroffen() {
        Zug zug = new Zug(8, 7);
        Zug zug1 = new Zug(8, 7);

        Antwort antwort = spielFeldService.antwortErstellen(zug);
        Antwort antwort1 = spielFeldService.antwortErstellen(zug1);
        assertTrue(antwort.isVersenkt());
        assertTrue(antwort1.isSchonMalGeschossen());
    }

    @Test
    void testAntwortErstellenBeenden() {
        spielFeldService.antwortErstellen(new Zug(0, 0));
        spielFeldService.antwortErstellen(new Zug(1, 0));
        spielFeldService.antwortErstellen(new Zug(2, 0));
        spielFeldService.antwortErstellen(new Zug(3, 0));
        spielFeldService.antwortErstellen(new Zug(1, 2));
        spielFeldService.antwortErstellen(new Zug(2, 2));
        spielFeldService.antwortErstellen(new Zug(7, 3));
        spielFeldService.antwortErstellen(new Zug(2, 4));
        spielFeldService.antwortErstellen(new Zug(5, 4));
        spielFeldService.antwortErstellen(new Zug(0, 5));
        spielFeldService.antwortErstellen(new Zug(2, 5));
        spielFeldService.antwortErstellen(new Zug(5, 5));
        spielFeldService.antwortErstellen(new Zug(0, 6));
        spielFeldService.antwortErstellen(new Zug(2, 6));
        spielFeldService.antwortErstellen(new Zug(5, 6));
        spielFeldService.antwortErstellen(new Zug(1, 8));
        spielFeldService.antwortErstellen(new Zug(2, 8));
        spielFeldService.antwortErstellen(new Zug(4, 8));
        spielFeldService.antwortErstellen(new Zug(6, 8));
        Antwort antwort = spielFeldService.antwortErstellen(new Zug(8, 7));

        assertTrue(antwort.isSpielBeendet());
    }
}

