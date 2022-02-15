package de.battleship.dao;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class BackendDAOImp implements BackendDAO{
    private int[][] feld;
    List<List<int[]>> schiffe;
    private List<int[]> letztesVersenktesSchiff;
    private boolean schonMalGeschossen;

    @Override
    public boolean istValide(int[][] feld, int anzahlBattleship, int anzahlCruiser, int anzahlDestroyer, int anzahlSubmarine) {
        Validator validator = new Validator(anzahlBattleship, anzahlCruiser, anzahlDestroyer, anzahlSubmarine);
        if (validator.fieldValidator(feld)){
            setFeld(feld);
            setSchiffe(validator.getSchiffe());
            return true;
        }
        else { return false; }
    }

    @Override
    public boolean istGetroffen(int x, int y) {
        this.schonMalGeschossen = false;

        if (feld[x][y] == 1)
        {
            feld[x][y] = 8; // Koordinaten vom getroffenen Schiffsteil
            return true;
        }
        else {
            if (feld[x][y] == 5 || feld[x][y] == 8)
            { this.schonMalGeschossen = true; }
            else
            { feld[x][y] = 5; } // Daneben geschossen
            return false;
        }
    }

    @Override
    public boolean schonMalGeschossen() { return schonMalGeschossen; }

    @Override
    public boolean istVersenkt(int x, int y) {

        for (List<int[]> schiff: schiffe){
            if (schiff.stream().anyMatch(a -> Arrays.equals(a, new int[]{x,y}))){
                for (int[] schiffsteil: schiff){ //Prüfen, ob das Schiff noch nicht getroffene Teile hat
                    if (feld[schiffsteil[0]][schiffsteil[1]] == 1) { return false; } //Nicht versenkt
                }
                letztesVersenktesSchiff = schiff;
                return true; //Versenkt. Das Schiff hat keine Teile mehr
            }
        }
        throw new RuntimeException();
    }

    @Override
    public boolean spielBeendet() {
        for (List<int[]> schiff: schiffe){
            for (int[] schiffsteil: schiff){
                if (feld[schiffsteil[0]][schiffsteil[1]] == 1) { return false; }
            }
        }
        return true;
    }

    @Override
    public List<int[]> getLetztesVersenktesSchiff() { return letztesVersenktesSchiff; }
    @Override
    public void setFeld(int[][] feld) {this.feld = Arrays.stream(feld).map(int[]::clone).toArray(int[][]::new); }
    @Override
    public List<List<int[]>> getSchiffe() { return schiffe; }
    private void setSchiffe(List<List<int[]>> schiffe) { this.schiffe = schiffe; }
}
