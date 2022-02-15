package bs.dao;

import org.junit.jupiter.api.Test;
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
}
