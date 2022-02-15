package bs.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DAOTest {
    static BackendDAOImp backendDAOImp = new BackendDAOImp();

    @Test
    void testValide() {
        int[][] testFeld = {{1, 0, 0, 0, 0, 1, 1, 0, 0, 0},
                            {1, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                            {0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        boolean check = backendDAOImp.istValide(testFeld,1,2,3,4);
        assertTrue(check);
    }

    @Test
    @DisplayName("Test 'Getroffen' should work")
    void testGetroffen()
    {
        boolean checkHit = backendDAOImp.istGetroffen(1,  8);
        assertTrue(checkHit);
        boolean checkHitFalse = backendDAOImp.istGetroffen(5,8);
        assertFalse(backendDAOImp.schonMalGeschossen() == true);
    }

    @Test
    @DisplayName("Test 'schon mal getroffen' should Work")
    void testMalGeschossen()
    {
        boolean checkAlreadyHit = backendDAOImp.schonMalGeschossen() == true;
    }

    @Test
    @DisplayName("Test 'Versenkt' should work")
    void testVersenkt()
    {
    boolean checkDown = backendDAOImp.istVersenkt(0, 1);
    assertFalse(checkDown);
    boolean checkDown1 = backendDAOImp.istGetroffen(1 , 1);
    assertTrue(checkDown1);
    }

    @Test
    @DisplayName("Test 'Beendet' should work")
    void testBeendet()
    {
        int [][] Schiff;
        boolean checkFinished = backendDAOImp.spielBeendet();
    }
}
