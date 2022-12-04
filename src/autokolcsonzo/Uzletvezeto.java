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
public class Uzletvezeto extends Felhasznalo {


    public Uzletvezeto(int azonosito, String email, String jelszo, int jogosultsag) {
        super(azonosito, email, jelszo, jogosultsag);
    }

    @Override
    public String toString() {
        return azonosito + ";" + email + ";" + jelszo + ";" + jogosultsag + "\n";
    }
}
