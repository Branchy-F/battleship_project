package bs.dao;

import java.util.List;

public class Antwort {
    private boolean getroffen;
    private boolean versenkt = false;
    private List<int[]> koordinaten = null;
    private boolean spielBeendet = false;
    private boolean schonMalGeschossen = true;


    public boolean isGetroffen() {
        return getroffen;
    }

    public void setGetroffen(boolean getroffen) {
        this.getroffen = getroffen;
    }

    public boolean isSpielBeendet() {
        return spielBeendet;
    }

    public boolean isVersenkt() {
        return versenkt;
    }

    public void setVersenkt(boolean versenkt) {
        this.versenkt = versenkt;
    }

    public List<int[]> getKoordinaten() {
        return koordinaten;
    }

    public void setKoordinaten(List<int[]> koordinaten) {
        this.koordinaten = koordinaten;
    }

    public boolean SpielBeendet() {
        return spielBeendet;
    }

    public void setSpielBeendet(boolean spielBeendet) {
        this.spielBeendet = spielBeendet;
    }

    public boolean SchonMalGeschossen() {
        return schonMalGeschossen;
    }

    public void setSchonMalGeschossen(boolean schonMalGeschossen) {
        this.schonMalGeschossen = schonMalGeschossen;
    }
}
