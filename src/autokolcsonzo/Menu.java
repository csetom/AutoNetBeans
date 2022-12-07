/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autokolcsonzo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author I04AYS_JZU5E7_L4XBQH_O13EQ9
 */
public class Menu {

    private ArrayList<Felhasznalo> felhasznalok = new ArrayList<>();
    private AutoKolcsonzes kolcsonzesek = new AutoKolcsonzes();
    private String email = "";
    private BufferedReader input;
    private String valasztottid = "";
    private Felhasznalo jelenlegifelhasznalo;

    void Start() {
        FajlBetoltes();

        String jelszo = "";
        String ugyfelnev = "";
        String telefonszam = "";
        String bankartyaszam = "";
        String lakcim = "";
        input = new BufferedReader(new java.io.InputStreamReader(System.in));
        try {
            do {
                System.out.println("----MENU----\n"
                        + "1. Bejelentkezes\n"
                        + "2. Regisztracio\n"
                        + "3. Kilepes\n"
                        + "----MENU----");
                System.out.println("Kerem adja meg a menupont szamat:");
                valasztottid = input.readLine();
                switch (valasztottid) {
                    case "1":
                        System.out.println("Belépés:\nKerem adja meg az email címét:");
                        email = input.readLine();
                        System.out.println("Kerem adja meg a jelszavát:");
                        jelszo = input.readLine();

                        if (Bejelentkezes(email, jelszo) == true) {
                            Bejelentkezve();
                        } else {
                            System.out.println("A jelszó vagy az email cím helytelen!");
                        }
                        valasztottid = "-1";
                        break;
                    case "2":
                        System.out.println("Regisztracio:\nKerem adja meg a nevet:");
                        ugyfelnev = input.readLine();
                        System.out.println("Kerem adja meg az email címét:");
                        email = input.readLine();
                        System.out.println("Kerem adja meg a jelszavat:");
                        jelszo = input.readLine();
                        System.out.println("Kerem adja meg a telefonszamat:");
                        telefonszam = input.readLine();
                        System.out.println("Kerem adja meg a bankartya szamat:");
                        bankartyaszam = input.readLine();
                        System.out.println("Kerem adja meg a lakcimet:");
                        lakcim = input.readLine();
                        if (LetezikE(email) == false) {
                            //(int azonosito, String email, String jelszo, int jogosultsag,
                            // String ugyfelnev,String telefonszam,String bankartyaszam,String lakcim,int fizetesID,int kolcsonzesID
                            felhasznalok.add(new Ugyfel(felhasznalok.size(), email, jelszo, 0, ugyfelnev, telefonszam, bankartyaszam, lakcim, -1, -1));
                            System.out.println("Regisztracio megtortent, most mar belephet!");
                            FajlbaKiirasfelhasznalok();
                        } else {
                            System.out.println("Megadott email cím már szerepel az adatbázisban!");
                        }
                        break;
                    case "3":
                        break;
                    default:
                        System.out.println("Ugy tunik nincs ilyen menupont :(");
                        break;
                }

            } while (!valasztottid.equals("3"));

        } catch (IOException ex) {

        }
        System.out.println("Kilepve");
        System.exit(0);
    }

    private boolean Bejelentkezes(String email, String jelszo) {
        for (Felhasznalo felhasznalo : felhasznalok) {
            if (felhasznalo.email.equals(email) && felhasznalo.jelszo.equals(jelszo)) {
                this.jelenlegifelhasznalo = felhasznalo;
                return true;
            }
        }
        return false;
    }

    private boolean LetezikE(String email) {
        for (Felhasznalo felhasznalo : felhasznalok) {
            if (felhasznalo.email.equals(email)) {
                return true;
            }
        }
        return false;
    }

    private void Bejelentkezve() {
        int jog = 0;
        System.out.println("Bejelentkezés megtörtént.");
        for (Felhasznalo felhasznalo : felhasznalok) {
            if (felhasznalo.email.equals(email)) {
                if (felhasznalo.getClass() == Admin.class) {
                    System.out.println("ADMIN:\n");
                    jog = 2;
                    break;
                } else if (felhasznalo.getClass() == Uzletvezeto.class) {
                    jog = 1;
                    System.out.println("Uzletvezeto:\n");
                    break;
                } else if (felhasznalo.getClass() == Ugyfel.class) {
                    jog = 0;
                    System.out.println("Ugyfel:" + ((Ugyfel) felhasznalo).Getugyfelnev() + "\n");
                    break;
                }
            }
        }
        switch (jog) {
            case 0:
                //ugyfel
                UgyfelMenu();
                break;
            case 1:
                //uzletvezeto
                UzletvezetoMenu();
                break;
            case 2:
                //admin
                AdminMenu();
                break;
        }
    }

    private void FajlbaKiirasfelhasznalok() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (FileWriter writer = new FileWriter("felhasznalok.txt")) {
                    for (int i = 0; i < felhasznalok.size(); i++) {
                        writer.write(felhasznalok.get(i).toString());
                    }
                    writer.close();
                    System.out.println("Fajlba kiiras megtortent (felhasznalo).");
                } catch (IOException ex) {
                    System.out.println("Nem hozhato letre a fajl!");
                }
            }
        }).start();

    }

    private void FajlbaKiiraskolcsonzesek() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try (FileWriter writer = new FileWriter("kolcsonzesek.txt")) {
                    for (int i = 0; i < kolcsonzesek.Meret(); i++) {
                        writer.write(kolcsonzesek.getAutok(i).toString() + kolcsonzesek.getKolcsonzesek(i).toString());
                    }
                    writer.close();
                    System.out.println("Fajlba kiiras megtortent(kolcsonzesek).");
                } catch (IOException ex) {
                    System.out.println("Nem hozhato letre a fajl!");
                }
            }
        }).start();
    }

    private void FajlBetoltes() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader BuffReader = null;
                try {
                    BuffReader = new BufferedReader(new FileReader("felhasznalok.txt"));
                    String[] tmp;
                    while ((tmp = BuffReader.readLine().split(";")) != null) {

                        switch (tmp.length) {

                            case 10:
                                //ügyfél
                                felhasznalok.add(new Ugyfel(Integer.parseInt(tmp[0]), tmp[1], tmp[2], Integer.parseInt(tmp[3]), tmp[4], tmp[5], tmp[6], tmp[7], Integer.parseInt(tmp[8]), Integer.parseInt(tmp[9])));
                                break;
                            case 5:
                                //admin
                                felhasznalok.add(new Admin(Integer.parseInt(tmp[0]), tmp[1], tmp[2], Integer.parseInt(tmp[3]), Integer.parseInt(tmp[4])));
                                break;
                            case 4:
                                //üzletvezető
                                felhasznalok.add(new Uzletvezeto(Integer.parseInt(tmp[0]), tmp[1], tmp[2], Integer.parseInt(tmp[3])));
                                break;
                            default:
                                break;
                        }
                    }

                } catch (FileNotFoundException ex) {

                } catch (IOException | NullPointerException ex) {

                }
                try {
                    BuffReader = new BufferedReader(new FileReader("kolcsonzesek.txt"));
                    {
                        String[] tmp;
                        while ((tmp = BuffReader.readLine().split(";")) != null) {
                            kolcsonzesek.addAutok(new Auto(tmp[0], tmp[1], tmp[2], tmp[3], Integer.parseInt(tmp[4]), tmp[5]));
                            kolcsonzesek.addKolcsonzesek(new Kolcsonzes(Integer.parseInt(tmp[6]), Integer.parseInt(tmp[7]), tmp[8], tmp[9], Integer.parseInt(tmp[10]), Integer.parseInt(tmp[11])));
                            switch (tmp.length) {
                                case 1:

                                    break;
                            }
                        }

                    }

                } catch (FileNotFoundException ex) {

                } catch (IOException | NullPointerException ex) {
                }
            }
        }
        ).start();
    }

    private void UzletvezetoMenu() {
        do {
            System.out.println("----MENU----\n"
                    + "1. Auto hozzaadas\n"
                    + "2. Valami\n"
                    + "3. Kijelentkezes\n"
                    + "----MENU----");
            System.out.println("Kerem adja meg a menupont szamat:");
            try {
                valasztottid = input.readLine();
                switch (valasztottid) {
                    case "1":
                        System.out.println("Auto hozzaadas:\n");
                        String rendszam,
                         tipus,
                         modell,
                         uzemanyag,
                         szin;
                        int ferohely,
                         ar;
                        System.out.println("Auto ar:");
                        ar = Integer.parseInt(input.readLine());
                        System.out.println("Auto rendszam:");
                        rendszam = input.readLine();
                        System.out.println("Auto tipus:");
                        tipus = input.readLine();
                        System.out.println("Auto modell:");
                        modell = input.readLine();
                        System.out.println("Auto uzemanyag:");
                        uzemanyag = input.readLine();
                        System.out.println("Auto ferohely:");
                        ferohely = Integer.parseInt(input.readLine());
                        System.out.println("Auto szin:");
                        szin = input.readLine();
                        kolcsonzesek.autok.add(new Auto(rendszam, tipus, modell, uzemanyag, ferohely, szin));
                        DateFormat datum = new SimpleDateFormat("yyyy.MM.dd");
                        kolcsonzesek.kolcsonzesek.add(new Kolcsonzes(kolcsonzesek.Meret(), -1, rendszam, datum.format(new Date()), ar, -1));
                        System.out.println("Auto hozzaadasa sikeresen megtortent:\n");
                        break;
                    case "2":

                        break;
                }
                FajlbaKiiraskolcsonzesek();
            } catch (IOException ex) {
            }
        } while (!valasztottid.equals("3"));
    }

    private void AdminMenu() {
        do {
            System.out.println("----MENU----\n"
                    + "1. Ugyfel modositas\n"
                    + "2. Kolcsonzes modositas\n"
                    + "3. Auto modositas\n"
                    + "4. Kijelentkezes\n"
                    + "----MENU----");
            System.out.println("Kerem adja meg a menupont szamat:");
            try {
                valasztottid = input.readLine();
                switch (valasztottid) {
                    case "1":
                        System.out.println("Ugyfelek:");

                        for (int i = 0; i < felhasznalok.size(); i++) {
                            if (felhasznalok.get(i).jogosultsag == 0) {
                                System.out.println(i + ".     " + felhasznalok.get(i).email + ";" + ((Ugyfel) felhasznalok.get(i)).Gettelefonszam() + ";" + ((Ugyfel) felhasznalok.get(i)).Getlakcim());
                            }
                        }
                        System.out.println("Kerem adja meg az sorszamat, hogy melyik ugyfel adatat kivanja modositani, ha nem szeretne modositani akkor nyomjon csak egy enter:");
                        valasztottid = input.readLine();
                        if (!valasztottid.equals("")) {
                            System.out.println("Kivalasztott ugyfel emailje:" + felhasznalok.get(Integer.parseInt(valasztottid)).email);
                            System.out.println("Email:");
                            felhasznalok.get(Integer.parseInt(valasztottid)).setEmail(input.readLine());
                            System.out.println("Telefonszam:");
                            ((Ugyfel) felhasznalok.get(Integer.parseInt(valasztottid))).Settelefonszam(input.readLine());
                            System.out.println("Lakcim:");
                            ((Ugyfel) felhasznalok.get(Integer.parseInt(valasztottid))).Setlakcim(input.readLine());

                            FajlbaKiirasfelhasznalok();
                        }
                        break;

                    case "2":
                        System.out.println("Kolcsonzesek:");
                        for (int i = 0; i < kolcsonzesek.Meret(); i++) {
                            System.out.println(i + ".     " + kolcsonzesek.kolcsonzesek.get(i).getAutorendszam() + ";" + kolcsonzesek.kolcsonzesek.get(i).getAr());
                        }
                        System.out.println("Ha nem szeretne modositani akkor nyomjon csak egy entert:");
                        String index = input.readLine();
                        if (!index.equals("")) {
                            System.out.println("Kolcsonzes auto rendszama:" + kolcsonzesek.kolcsonzesek.get(Integer.parseInt(valasztottid)).getAutorendszam());
                            System.out.println("Auto ara:");
                            valasztottid = input.readLine();
                            if (!valasztottid.equals("")) {
                                kolcsonzesek.kolcsonzesek.get(Integer.parseInt(index)).setAr(Integer.parseInt(valasztottid));
                                FajlbaKiiraskolcsonzesek();
                            }

                        }
                        break;

                    case "3":
                        System.out.println("Autok:");
                        for (int i = 0; i < kolcsonzesek.Meret(); i++) {
                            System.out.println(i + ".     " + kolcsonzesek.autok.get(i).getRendszam() + ";" + kolcsonzesek.autok.get(i).getTipus() + ";" + kolcsonzesek.autok.get(i).getModell() + ";" + kolcsonzesek.autok.get(i).getSzin());
                        }
                        System.out.println("Kerem adja meg az auto sorszamat. Ha nem szeretne modositani akkor nyomjon csak egy entert:");

                        try {
                            valasztottid = input.readLine();
                        } catch (IOException ex) {

                        }

                        if (!valasztottid.equals("")) {
                            System.out.println("Kivalasztott auto rendszama:" + kolcsonzesek.autok.get(Integer.parseInt(valasztottid)).getRendszam());
                            System.out.println("Auto szine:");
                            kolcsonzesek.autok.get(Integer.parseInt(valasztottid)).setSzin(input.readLine());
                            FajlbaKiiraskolcsonzesek();
                        }

                        break;
                }

            } catch (IOException ex) {

            }
        } while (!valasztottid.equals(
                "4"));
    }

    private void UgyfelMenu() {
        do {
            System.out.println("----MENU----\n"
                    + "1. Profil modositas\n"
                    + "2. Jelenlegi kolcsonzes\n"
                    + "3. Autokereses\n"
                    + "4. Auto kivalasztas\n"
                    + "5. Auto leadas\n"
                    + "6. Kijelentkezés\n"
                    + "----MENU----");
            System.out.println("Kerem adja meg a menupont szamat:");
            try {
                valasztottid = input.readLine();
                switch (valasztottid) {
                    case "1":

                        do {
                            System.out.println("----Profil modositas----\n"
                                    + "1. Lakcim\n"
                                    + "2. Jelszo\n"
                                    + "3. Bank kartyaszam\n"
                                    + "4. Telefonszam\n"
                                    + "5. Visszalepes\n"
                                    + "----Profil modositas----"
                            );
                            System.out.println("----Felhasznalo adatai----\n"
                                    + "Lakcim:" + ((Ugyfel) jelenlegifelhasznalo).Getlakcim() + "\n"
                                    + "Telefonszam:" + ((Ugyfel) jelenlegifelhasznalo).Gettelefonszam() + "\n"
                                    + "----Felhasznalo adatai----"
                            );
                            System.out.println("Kerem adja meg a menupont szamat:");
                            valasztottid = input.readLine();
                            switch (valasztottid) {
                                case "1":
                                    System.out.println("Kerem adja meg a lakcimet:");
                                    ((Ugyfel) jelenlegifelhasznalo).Setlakcim(input.readLine());
                                    break;
                                case "2":
                                    System.out.println("Kerem adja meg az uj jelszavat:");
                                    ((Ugyfel) jelenlegifelhasznalo).Setjelszo(input.readLine());
                                    break;
                                case "3":
                                    System.out.println("Kerem adja meg a bank kartyaszamat:");
                                    ((Ugyfel) jelenlegifelhasznalo).Setbankkartyacim(input.readLine());
                                    break;
                                case "4":
                                    System.out.println("Kerem adja meg a telefonszamat:");
                                    ((Ugyfel) jelenlegifelhasznalo).Settelefonszam(input.readLine());
                                    break;
                            }
                            for (Felhasznalo felhasznalo : felhasznalok) {
                                if (jelenlegifelhasznalo.email.equals(felhasznalo.email)) {
                                    felhasznalo = jelenlegifelhasznalo;
                                    break;
                                }
                            }
                            FajlbaKiirasfelhasznalok();
                        } while (!valasztottid.equals("5"));
                        break;
                    case "2":
                        System.out.println("Kikolcsonzott jarmu:\n");
                        for (int i = 0; i < kolcsonzesek.Meret(); i++) {
                            if (kolcsonzesek.kolcsonzesek.get(i).getUgyfelID() == jelenlegifelhasznalo.azonosito) {
                                System.out.println(kolcsonzesek.autok.get(i).toString() + "\n");

                            }
                        }
                        break;
                    case "3":
                        String szures="*";
                        boolean kiLep=false;
                        while(!kiLep) {
                            System.out.println("Jarmuvek:");
                            for (int i = 0; i < kolcsonzesek.Meret(); i++) {
                                Kolcsonzes k = kolcsonzesek.kolcsonzesek.get(i);
                                if (k.getUgyfelID() == -1 && ((k.getAutorendszam().contains(szures))|| szures.equals("*"))) {
                                    System.out.println(kolcsonzesek.autok.get(i) + "\n");
                                }
                            }
                            System.out.print("Rendszam/exit:");
                            szures=input.readLine(); 
                            kiLep=szures.equals("exit");
                        }

                        break;
                    case "4":
                        boolean van = false;
                        for (int i = 0; i < kolcsonzesek.Meret(); i++) {
                            if (kolcsonzesek.kolcsonzesek.get(i).getUgyfelID() == jelenlegifelhasznalo.azonosito) {
                                System.out.println("Kerjuk eloszor adja le a kolcsonzott autot!");
                                van=true;
                                break;
                            }
                        }                                            
                        if (!van) {                           
                            System.out.println("Auto kivalasztasa, kerem a rendszamat:");
                            valasztottid = input.readLine();
                            for (int i = 0; i < kolcsonzesek.Meret(); i++) {
                                if (kolcsonzesek.autok.get(i).getRendszam().equals(valasztottid)) {
                                    Auto  a= kolcsonzesek.autok.get(i);
                                    System.out.println("On a kovetkezo autot akarja valasztani es kifizetni(igen/nem):" );
                                    System.out.println(a.toString());                                    
                                    String valasz = input.readLine();
                                     if (valasz.equals("igen")) {
                                        kolcsonzesek.kolcsonzesek.get(i).setUgyfelID(((Ugyfel) jelenlegifelhasznalo).azonosito);
                                        //Utanfuto
                                        System.out.println("Sikeresen kikolcsonozve" );                                                 
                                     }
                                    break;
                                }
                            }
                        }
                        break;
                    case "5":
                        int index = -1;
                        for (int i = 0; i < kolcsonzesek.Meret(); i++) {
                            if (kolcsonzesek.kolcsonzesek.get(i).getUgyfelID() == jelenlegifelhasznalo.azonosito) {
                                index = i;
                                break;
                            }
                        }
                        if (index != -1) {
                            System.out.println("Leadja a kolcsonzott autot? (igen/nem)");
                            valasztottid = input.readLine();
                            if (valasztottid.equals("igen")) {
                                kolcsonzesek.kolcsonzesek.get(index).setUgyfelID(-1);                           
                                System.out.println("Sikeresen leadta az autot");
                            }
                        } else {
                            System.out.println("Nincs mit leadni!");
                        }
                        break;
                }
                FajlbaKiirasfelhasznalok();
                FajlbaKiiraskolcsonzesek();

            } catch (IOException ex) {

            }
        } while (!valasztottid.equals("6"));
    }

}
