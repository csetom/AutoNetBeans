/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcsonzo;

/**
 *
 * @author I04AYS_JZU5E7_L4XBQH_O13EQ9
 */
public class Kolcsonzes {

    private int kolcsonzesID;
    private int ugyfelID;
    private String autorendszam;
    private String datum;
    private int ar;

    public Kolcsonzes(int kolcsonzesID, int ugyfelID, String autorendszam, String datum, int ar, int kolcsonzesallapot) {
        this.kolcsonzesID = kolcsonzesID;
        this.ugyfelID = ugyfelID;
        this.autorendszam = autorendszam;
        this.datum = datum;
        this.ar = ar;
        this.kolcsonzesallapot = kolcsonzesallapot;
    }
    private int kolcsonzesallapot;

    @Override
    public String toString() {
        return ";" + kolcsonzesID + ";" + ugyfelID + ";" + autorendszam + ";" + datum + ";" + ar + ";" + kolcsonzesallapot + "\n";
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

    public String getAutorendszam() {
        return autorendszam;
    }

    public void setAutorendszam(String autorendszam) {
        this.autorendszam = autorendszam;
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
