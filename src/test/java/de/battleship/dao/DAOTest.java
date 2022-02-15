package de.battleship.dao;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class DAOTest {
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

    static BackendDAO backendDAO = new BackendDAOImp();

    @BeforeEach
    public void vorJedemTests() { backendDAO.setFeld(testFeld); }

//    @Test
//    void testValide() {
//        boolean check = backendDAO.istValide(testFeld,1,2,3,4);
//        assertTrue(check);
//    }
//
//    @Test
//    void testGetroffen()
//    {
//        boolean checkHit = backendDAO.istGetroffen(0,  0);
//        assertTrue(checkHit);
//        boolean checkHitFalse = backendDAO.istGetroffen(1,1);
//        assertFalse(checkHitFalse);
//        backendDAO.setFeld(testFeld);
//    }
//
//    @Test
//    void testMalGeschossen()
//    {
//        backendDAO.istGetroffen(0,0);
//        backendDAO.istGetroffen(0,0);
//        assertTrue(backendDAO.schonMalGeschossen());
//    }

    @Test
    void testVersenkt()
    {
        backendDAO.istValide(testFeld, 1,2,3,4);
        List<int[]> schiff = backendDAO.getSchiffe().get(0);

        int x = -1; int y = -1;
        for (int[] schiffsTeil : schiff){
            x = schiffsTeil[0];
            y = schiffsTeil[1];
            backendDAO.istGetroffen(x, y);
        }

        boolean checkDown = backendDAO.istVersenkt(x, y);
        assertNotNull(backendDAO.getLetztesVersenktesSchiff());
        assertTrue(checkDown);

    }
}
