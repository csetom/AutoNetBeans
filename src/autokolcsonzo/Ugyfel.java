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
public class Ugyfel extends Felhasznalo {

    private String ugyfelnev;
    private int kolcsonzesID;
    private String telefonszam;
    private String bankartyaszam;
    private String lakcim;
    private int fizetesID;
//int azonosito, String email, String jelszo, int jogosultsag

    public Ugyfel(int azonosito, String email, String jelszo, int jogosultsag,
            String ugyfelnev, String telefonszam, String bankartyaszam, String lakcim, int fizetesID, int kolcsonzesID) {
        super(azonosito, email, jelszo, jogosultsag);
        this.ugyfelnev = ugyfelnev;
        this.kolcsonzesID = kolcsonzesID;
        this.telefonszam = telefonszam;
        this.bankartyaszam = bankartyaszam;
        this.lakcim = lakcim;
        this.fizetesID = fizetesID;
    }

    @Override
    public String toString() {
        return azonosito + ";" + email + ";" + jelszo + ";" + jogosultsag + ";" + ugyfelnev + ";" + telefonszam + ";" + bankartyaszam + ";" + lakcim + ";" + fizetesID + ";" + kolcsonzesID + "\n";
    }

    public String Getugyfelnev() {
        return ugyfelnev;
    }

    public String Getlakcim() {
        return lakcim;
    }

    public String Gettelefonszam() {
        return telefonszam;
    }

    public String Getbankartyaszam() {
        return bankartyaszam;
    }

    public void Setlakcim(String beirt) {
        if (!beirt.equals("")) {
            this.lakcim = beirt;
        }
    }

    public void Settelefonszam(String beirt) {
        if (!beirt.equals("")) {
            telefonszam = beirt;
        }
    }

    public void Setbankkartyacim(String beirt) {
        bankartyaszam = beirt;
    }
}
