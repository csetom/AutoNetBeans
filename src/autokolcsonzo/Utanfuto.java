package autokolcsonzo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tcses
 */
public class Utanfuto {
    private String rendszam;
    private String tipus;
    private String modell;
    private int meret;
    private String szin;
   
    
    public String getRendszam() {
        return rendszam;
    }

    public void setRendszam(String rendszam) {
        this.rendszam = rendszam;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public String getModell() {
        return modell;
    }

    public void setModell(String modell) {
        this.modell = modell;
    }


    @Override
    public String toString() {
        return rendszam + ";" + tipus + ";" + modell + ";" +  meret + ";" + szin;
    }

    public Utanfuto(String rendszam, String tipus, String modell,  int meret, String szin) {
        this.rendszam = rendszam;
        this.tipus = tipus;
        this.modell = modell;
        this.meret = meret;
        this.szin = szin;
    }

    public int getMeret() {
        return meret;
    }

    public void setMeret(int meret) {
        this.meret = meret;
    }

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        if (!szin.equals("")) {
            this.szin = szin;
        }
    }

}
