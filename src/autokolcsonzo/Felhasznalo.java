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
public class Felhasznalo {

    protected int azonosito;
    protected String email;

    public void setEmail(String email) {
        if (!email.equals("")) {
            this.email = email;
        }
    }

    protected String jelszo;
    protected int jogosultsag;

    public Felhasznalo(int azonosito, String email, String jelszo, int jogosultsag) {
        this.azonosito = azonosito;
        this.email = email;
        this.jelszo = jelszo;
        this.jogosultsag = jogosultsag;
    }

    @Override
    public String toString() {
        return azonosito + ";" + email + ";" + jelszo + ";" + jogosultsag + "\n";
    }

    public void Setjelszo(String beirt) {
        this.jelszo = beirt;
    }
}
