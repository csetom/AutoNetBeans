/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcsonzo;

import java.util.ArrayList;

/**
 *
 * @author I04AYS_JZU5E7_L4XBQH_O13EQ9
 */
public class AutoKolcsonzes {
    
    ArrayList<Kolcsonzes> kolcsonzesek = new ArrayList<>();
    ArrayList<Auto> autok = new ArrayList<>();
    ArrayList<UtanfutoKolcsonzes> utanfutoKolcsonzesek = new ArrayList<>();
    ArrayList<Utanfuto> Utanfutok = new ArrayList<>();

    public int Meret()
    {
        return autok.size();
    }

    public ArrayList<UtanfutoKolcsonzes> getUtanfutoKolcsonzesek() {
        return utanfutoKolcsonzesek;
    }

    public void setUtanfutoKolcsonzesek(ArrayList<UtanfutoKolcsonzes> utanfutoKolcsonzesek) {
        this.utanfutoKolcsonzesek = utanfutoKolcsonzesek;
    }

    public ArrayList<Utanfuto> getUtanfutok() {
        return Utanfutok;
    }

    public void setUtanfutok(ArrayList<Utanfuto> Utanfutok) {
        this.Utanfutok = Utanfutok;
    }
    
    public Kolcsonzes getKolcsonzesek(int index) {
        return kolcsonzesek.get(index);
    }
    
    public void setKolcsonzesek(ArrayList<Kolcsonzes> kolcsonzesek) {
        this.kolcsonzesek = kolcsonzesek;
    }
    
    public Auto getAutok(int index) {
        return autok.get(index);
    }
    
    public void setAutok(ArrayList<Auto> autok) {
        this.autok = autok;
    }
    
    public void addAutok(Auto auto) {
        autok.add(auto);
    }
    
    public void addKolcsonzesek(Kolcsonzes kolcsonzes) {
        kolcsonzesek.add(kolcsonzes);
    }

    /*@Override
    public String toString() {
        String szoveg = "";
        
        for (Kolcsonzes kolcsonzes : kolcsonzesek) {
            szoveg += kolcsonzes.toString() + ";";
        }
        for (Auto auto : autok) {
            szoveg += auto.toString() + ";";
        }
        return szoveg;
    }*/
}
