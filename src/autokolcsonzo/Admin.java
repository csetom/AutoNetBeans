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
public class Admin extends Felhasznalo {

    private int adminjog;

    public Admin(int azonosito, String email, String jelszo, int jogosultsag,int adminjog) {
        super(azonosito, email, jelszo, jogosultsag);
        this.adminjog=adminjog;
    }
    
        @Override
    public String toString() {
        return azonosito + ";" + email + ";" + jelszo + ";" + jogosultsag + ";"+ adminjog + "\n";
    }
    
    public void kivalasztas() {

    }

    public void ugyfelModositas() {

    }

    public void kolcsonzesModositas() {

    }

    public void autoModositas() {

    }
}
