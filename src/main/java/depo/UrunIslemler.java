package depo;

import java.util.*;

public class UrunIslemler extends Urun {

    static HashMap<String,Urun > urunHm = new HashMap<>();


    Scanner input = new Scanner(System.in);

    public void urunTanimlama() {
        input = new Scanner(System.in);
        UUID uniqueId = UUID.randomUUID();
        String id = uniqueId.toString().substring(0, 5);

        System.out.println("Lutfen Urun ismini giriniz");
        String urunIsim = input.nextLine();

        System.out.println("Lutfen Uretici ismini giriniz");
        String uretici = input.nextLine();

        System.out.println("Lutfen Urunun Birimini giriniz");
        String birim = input.nextLine();

        int miktar =0;
        String raf ="-";

        Urun urun = new Urun(urunIsim, uretici, miktar, birim, raf);
        System.out.println(urun);

        urunHm.put(id,urun);
        System.out.println(urunHm);


    }


    public void urunListele() {

    }

    public void urunGirisi() {

        System.out.println("lutfen ekleyeceghiniz urunun Id 'sini' giriniz..");
        String id = input.nextLine();

        System.out.println("Lutfen Urun miktarini giriniz");
        double miktar = input.nextDouble();


    }

    public void urunuRafaKoy() {

    }

    public void urunCikisi() {

    }


}
