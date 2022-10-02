package ba.unsa.etf.rpr;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Kviz k=new Kviz("Nejlin kviz", SistemBodovanja.BINARNO);
        Pitanje p1=new Pitanje("Da li je diskretna matematika najteži predmet u 3. semestru?",4);
        p1.dodajOdgovor("a", "Jeste sigurno, teže ne može",true);
        p1.dodajOdgovor("b","Ne", false);
        p1.dodajOdgovor("c","Možda",false);
        k.dodajPitanje(p1);
        Pitanje p2=new Pitanje("Hoće li BiH ući u EU?",5);
        p2.dodajOdgovor("a","Da", true);
        p2.dodajOdgovor("b","Ne",false);
        k.dodajPitanje(p2);
        Pitanje p3=new Pitanje("Završi rečenicu: Neće grom u...",3);
        p3.dodajOdgovor("1","koprive",true);
        p3.dodajOdgovor("2","majmune", false);
        k.dodajPitanje(p3);
        igrajKviz(k);
    }

    public static void igrajKviz(Kviz kviz){
        try {
            Map<Pitanje, ArrayList<String>> sve = new HashMap<>();
            for (Pitanje p : kviz.getPitanja()) {
                ArrayList<String> odgovoriJednogPitanja = new ArrayList<>();
                System.out.println(p);
                System.out.println("\nUnesite Vaše odgovore odvojene sa ENTER(x za kraj): ");
                for (; ; ) {
                    Scanner ulaz = new Scanner(System.in);
                    String odg = ulaz.nextLine();
                    if (odg.equals("x")) break;
                    else odgovoriJednogPitanja.add(odg);
                }
                sve.put(p, odgovoriJednogPitanja);
            }
            System.out.println("\n Kviz je gotov!");
            RezultatKviza rez = kviz.predajKviz(sve);
            System.out.println(rez);
            System.out.println("\nDa li želite pregledati tačne odgovore(Odgovorite sa DA/NE)? ");
            Scanner ulaz = new Scanner(System.in);
            String da = ulaz.nextLine();
            if (da.equals("DA")) System.out.println(kviz + "\nHvala Vam na učestvovanju.");
            else if (da.equals("NE")) System.out.println("\nHvala Vam na učestvovanju.");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
