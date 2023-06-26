package miniDepoProjesi;

import java.util.*;

public class Service extends Urun {

    Scanner input = new Scanner(System.in);
    HashMap<String, Urun> urunHm = new HashMap<>();

    public Service() {

    }


    public void urunTanimla() {

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().substring(0, 5);


        System.out.println("lutfen Urun ismini giriniz");

        String urunIsim = null;
        try {
            urunIsim = input.nextLine();
        } catch (InputMismatchException e) {
            System.err.println("Hatali giris. Lutfen uygun deger giriniz");
        }

        System.out.println("lutfen Uretici ismini giriniz");
        String uretici = input.nextLine();
        System.out.println("lutfen Urunun birimini giriniz");
        String birim = input.nextLine();
        double miktar = 0;
        String raf = "-";

        Urun urun = new Urun(urunIsim, uretici, miktar, birim, raf);


        urunHm.put(id, urun);

        System.out.println(urunHm);
    }


    public void urunListele() {
        System.out.println("urun listelendi");
    }


    public void urunGir() {

        System.out.println("Lutfen Miktarini girmek istediginiz urunun ID'sini giriniz");
        String id = input.nextLine().trim();

        if (urunHm.containsKey(id)) {
            System.out.println("Lutfen " + id + " id numarali urun icin miktar giriniz..");

            double miktar = input.nextDouble(); //trycatch uygulanacak


            for (Map.Entry<String, Urun> w : urunHm.entrySet()) {

                Urun urun = w.getValue();

                double mevcutMiktar = urun.getMiktar();
                double yeniMiktar = mevcutMiktar+miktar;

                urun.setMiktar(yeniMiktar);




            }


        }


    }


    public void urunuRafaKoy() {

    }


    public void urunCikisiYap() {

    }

    public int intHataliGiris() {
        boolean falseGir = false;
        int sec = 0;
        do {

            try {
                sec = input.nextInt();
                input.nextLine();       //dummyCod
                falseGir = true;
            } catch (InputMismatchException e) {
                System.out.println("yanlis deger girdiniz");
                System.out.println("lutfen Tekrar giris yapiniz");
                input.nextLine();       //Girdi bufferini temizleme
            }

            if (sec < 0) {
                System.out.println("Negatif deger girdiniz!!!");
                falseGir = true;
            }


        } while (!falseGir);

        return sec;

    }

}
