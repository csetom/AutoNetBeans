package autokolcsonzo;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author tcses
 */
public class UtanfutoKolcsonzes {

    private int kolcsonzesID;
    private int ugyfelID;
    private String utanfutorendszam;
    private String datum;
    private int ar;

    public UtanfutoKolcsonzes(int kolcsonzesID, int ugyfelID, String utanfutorendszam, String datum, int ar, int kolcsonzesallapot) {
        this.kolcsonzesID = kolcsonzesID;
        this.ugyfelID = ugyfelID;
        this.utanfutorendszam = utanfutorendszam;
        this.datum = datum;
        this.ar = ar;
        this.kolcsonzesallapot = kolcsonzesallapot;
    }
    private int kolcsonzesallapot;

    @Override
    public String toString() {
        return ";" + kolcsonzesID + ";" + ugyfelID + ";" + utanfutorendszam + ";" + datum + ";" + ar + ";" + kolcsonzesallapot + "\n";
    }

    public int getKolcsonzesID() {
        return kolcsonzesID;
    }

    public void setKolcsonzesID(int kolcsonzesID) {
        this.kolcsonzesID = kolcsonzesID;
    }

    public int getUgyfelID() {
        return ugyfelID;
    }

    public void setUgyfelID(int ugyfelID) {
        this.ugyfelID = ugyfelID;
    }

    public String getUtanfutorendszam() {
        return utanfutorendszam;
    }

    public void setUtanfutorendszam(String utanfutorendszam) {
        this.utanfutorendszam = utanfutorendszam;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        if (ar > 0) {
            this.ar = ar;
        }
    }

    public int getKolcsonzesallapot() {
        return kolcsonzesallapot;
    }

    public void setKolcsonzesallapot(int kolcsonzesallapot) {
        this.kolcsonzesallapot = kolcsonzesallapot;
    }
}
