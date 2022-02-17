package de.battleship.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class SocketverbindungTest { // BSSocket
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

    SpielFeldService service1;
    SpielFeldService service2;
    BSSocket bsSocket1;
    BSSocket bsSocket2;

    @BeforeAll
    void init() {
        service1 = new SpielFeldServiceImp();
        service2 = new SpielFeldServiceImp();
        service1.istValide(testFeld);
        service2.istValide(testFeld);

        try {
            bsSocket1 = new BSSocket(service1, "localhost", 22000, 22001);
            bsSocket2 = new BSSocket(service2, "localhost", 22001, 22000);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

