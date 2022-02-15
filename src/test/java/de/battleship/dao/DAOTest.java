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

    @Test
    void testValide() {
        boolean check = backendDAO.istValide(testFeld,1,2,3,4);
        assertTrue(check);
    }

    @Test
    void testGetroffen()
    {
        boolean checkHit = backendDAO.istGetroffen(0,  0);
        assertTrue(checkHit);
        boolean checkHitFalse = backendDAO.istGetroffen(1,1);
        assertFalse(checkHitFalse);
        backendDAO.setFeld(testFeld);
    }

    @Test
    void testMalGeschossen()
    {
        backendDAO.istGetroffen(0,0);
        backendDAO.istGetroffen(0,0);
        assertTrue(backendDAO.schonMalGeschossen());
    }

    @Test
    void testVersenkt()
    {
        int[][] schiff = new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{2, 0}, new int[]{3, 0},};

        for (int[] schiffsTeil : schiff){
            assertTrue(backendDAO.istGetroffen(schiffsTeil[0], schiffsTeil[1]));
        }

        assertNotNull(backendDAO.getLetztesVersenktesSchiff());

        boolean checkDown = backendDAO.istVersenkt(3, 0);
        assertTrue(checkDown);

    }
}
