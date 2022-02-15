package de.battleship.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DAOTest {
    static BackendDAO backendDAO = new BackendDAOImp();

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

        boolean check = backendDAO.istValide(testFeld,1,2,3,4);
        assertTrue(check);
    }
}
