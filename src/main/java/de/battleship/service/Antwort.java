package de.battleship.service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Antwort implements Serializable {
    private boolean getroffen = false;
    private boolean schonMalGeschossen = false;
    private boolean versenkt = false;
    private List<int[]> koordinaten = new ArrayList<>();
    private boolean spielBeendet = false;


    public boolean isGetroffen() { return getroffen; }

    public void setGetroffen(boolean getroffen) { this.getroffen = getroffen; }

    public boolean isVersenkt() { return versenkt; }

    public void setVersenkt(boolean versenkt) { this.versenkt = versenkt; }

    public List<int[]> getKoordinaten() { return koordinaten; }

    public void setKoordinaten(List<int[]> koordinaten) { this.koordinaten = koordinaten; }

    public boolean isSpielBeendet() { return spielBeendet; }

    public void setSpielBeendet(boolean spielBeendet) { this.spielBeendet = spielBeendet; }

    public boolean isSchonMalGeschossen() { return schonMalGeschossen; }

    public void setSchonMalGeschossen(boolean schonMalGeschossen) { this.schonMalGeschossen = schonMalGeschossen; }

//    @Override
//    public String toString() {
//        StringBuilder stringBuilder = new StringBuilder();
//        for (int[] k : koordinaten){ Stream.of(k).map(Arrays::toString).forEach(s -> stringBuilder.append(s).append(",")); }
//        stringBuilder.setLength(stringBuilder.length() - 1);
//
//        return String.format("%b;%b;%b;%s;%b", getroffen, schonMalGeschossen, versenkt, stringBuilder, spielBeendet);
//    }


    @Override
    public String toString() {
        return "Antwort{" +
                "getroffen=" + getroffen +
                ", schonMalGeschossen=" + schonMalGeschossen +
                ", versenkt=" + versenkt +
                ", koordinaten=" + koordinaten +
                ", spielBeendet=" + spielBeendet +
                '}';
    }
}
