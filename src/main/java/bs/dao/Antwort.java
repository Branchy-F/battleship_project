package bs.dao;

public class Antwort {
    private boolean getroffen;
    private boolean versenkt = false;
    private int[] koordinaten = null;
    private boolean spielenWeiter = true;
    private int gewinner = 0;

    //nicht getroffen
    public Antwort(boolean getroffen) {
        this.getroffen = getroffen;
    }

    //getroffen und nicht versenkt
    public Antwort(boolean getroffen, boolean versenkt) {
        this.getroffen = getroffen;
        this.versenkt = versenkt;
    }

    //Letzte Antwort (Spiel ist zu Ende)
    public Antwort(boolean getroffen, boolean versenkt, int[] koordinaten, boolean spielenWeiter, int gewinner) {
        this.getroffen = getroffen;
        this.versenkt = versenkt;
        this.koordinaten = koordinaten;
        this.spielenWeiter = spielenWeiter;
        this.gewinner = gewinner;
    }

    public boolean isGetroffen() {return getroffen; }
    public boolean isVersenkt() { return versenkt; }
    public int[] getKoordinaten() { return koordinaten; }
    public boolean isSpielenWeiter() { return spielenWeiter; }
    public int getGewinner() {return gewinner; }
}
