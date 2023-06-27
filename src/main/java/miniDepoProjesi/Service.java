package miniDepoProjesi;

import java.util.*;

public class Service extends Urun {


    Scanner input = new Scanner(System.in);
    HashMap<String, Urun> urunHm = new HashMap<>();

    public Service() {

    }

    void urunTanimla() {

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().substring(0, 5).toUpperCase();


        System.out.println("Lutfen urun ismini giriniz");

        String urunIsim = null;
        try {
            urunIsim = input.nextLine();
        } catch (InputMismatchException e) {
            System.err.println(ANSI_RED + "Hatali giris. Lutfen uygun deger giriniz" + ANSI_RESET);
        }
        System.out.println("Lutfen uretici ismini giriniz");
        String uretici = input.nextLine();
        System.out.println("Lutfen urunun birimini giriniz");
        String birim = input.nextLine();
        String raf = "-";


        double miktar = 0;
        if (urunVarMi(urunIsim, uretici, birim)) {       // buraada 40 dakika ugrastik siz de ugrsin :)
            System.err.println("Girilen urun daha once tanimlanmis bir urundur. Tekrar giris yapiniz");
        } else {
            Urun urun = new Urun(urunIsim, uretici, miktar, birim, raf);

            urunHm.put(id, urun);

        }

    }

    public boolean urunVarMi(String urunIsim, String uretici, String birim) {
        boolean ayniMi = false;

        if (!urunHm.isEmpty()) {
            for (Map.Entry<String, Urun> w : urunHm.entrySet()) {
                Urun urun = w.getValue();
                ayniMi = urunIsim.equalsIgnoreCase(urun.getUrunIsmi()) && uretici.equalsIgnoreCase(urun.getUretici()) && birim.equalsIgnoreCase(urun.getBirim());

            }

        } else {
            ayniMi = false;
        }


        return ayniMi;
    }


    public void urunListele() {
        System.out.println("-------------------------------------------------------------------------------------------------------");
        System.out.printf(ANSI_BLUE + "| %-15S |  %-15S | %-20S | %-15S | %-15S | %-15S %n" + ANSI_RESET, "ID NO", "URUN ISMI", "URETICI FIRMA", "URUN BIRIM", "MIKTAR", "RAF");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (Map.Entry<String, Urun> w : urunHm.entrySet()) {
            Urun urun = w.getValue();
            urun.getUrunIsmi();
            System.out.printf("| %-15S | %s%-15S%s | %s%-20S%s | %s%-15S%s | %s%-15S%s | %s%-15S%s %n",
                    w.getKey(), ANSI_GREEN, urun.getUrunIsmi(), ANSI_RESET, ANSI_GREEN, urun.getUretici(), ANSI_RESET, ANSI_GREEN, urun.getBirim(), ANSI_RESET, ANSI_RED, urun.getMiktar(), ANSI_RESET, ANSI_GREEN, urun.getRaf(), ANSI_RESET);
//            System.out.println("----------------------------------------------------------------------------------------------------");
        }
    }

    public void urunGir() {
        urunListele();
        System.out.println("Lutfen Miktarini girmek istediginiz urunun ID'sini giriniz");
        String id = input.nextLine().trim();

        if (urunHm.containsKey(id)) {
            System.out.println("Lutfen " + id + " id numarali urun icin miktar giriniz..");
            double miktar = doubleHataliGiris();
            for (Map.Entry<String, Urun> w : urunHm.entrySet()) {
                if (w.getKey().equals(id)) {
                    Urun urun = w.getValue();
                    double mevcutMiktar = urun.getMiktar();
                    double yeniMiktar = mevcutMiktar + miktar;
                    urun.setMiktar(yeniMiktar);
                    System.out.printf(ANSI_GREEN + id + " numarali urun icin " + ANSI_RED + urun.getMiktar() + ANSI_RESET + " " + ANSI_GREEN + urun.getBirim() + " miktar  girilmistir" + ANSI_RESET);
                }
            }
        } else System.err.println("ID bulunamadi. Lutfen gecerli bir ID giriniz..");
    }


    public void urunuRafaKoy() {
        urunListele();
        System.out.println("Lutfen rafa yerlestirmek istediginiz urunun ID'sini giriniz");
        String id = input.nextLine().trim();
        if (urunHm.containsKey(id)) {
            System.out.println("Lutfen yerlestirmek istediginiz rafi seciniz");
            String raf = input.nextLine();
            for (Map.Entry<String, Urun> w : urunHm.entrySet()) {
                if (w.getKey().equals(id)) {
                    Urun urun = w.getValue();
                    if (urun.getMiktar() > 0) {
                        urun.setRaf(raf);
                    } else {
                        System.err.println("Stokta urun mevcut degil.");
                    }
                }
            }
        } else {
            System.err.println("Girdiginiz ID ye ait kayit bulunamadi.");
        }
    }

    public void urunCikisiYap() {
        urunListele();
        boolean sart =true;
        do {
        System.out.println("Lutfen cikis yapmak istediginiz urunun ID'sini giriniz");
        String id = input.nextLine().trim();



            if (urunHm.containsKey(id)) {
            System.out.println("Lutfen cikis yapmak istediginiz urunun miktarini giriniz.");

            double miktar = doubleHataliGiris();

            for (Map.Entry<String, Urun> w : urunHm.entrySet()) {
                if (w.getKey().equals(id)) {
                    Urun urun = w.getValue();
                    if (miktar <= urun.getMiktar()) {
                        double guncelMiktar = urun.getMiktar() - miktar;
                        urun.setMiktar(guncelMiktar);
                        System.out.printf(ANSI_GREEN + "Depodan urun cikisi yapilmistir.\nGuncel miktar : " + ANSI_RED + urun.getMiktar() + ANSI_RESET + " " + urun.getBirim() + " bulunmaktadir." + ANSI_RESET);
                        sart =false;
                        break;
                    } else {
                        System.err.println("Yeterli urun bulunmamaktadir.\nDepoda " + ANSI_RED + urun.getMiktar() + ANSI_RESET + " " + urun.getBirim() + " bulunmaktadir.");
                    }
                }
            }
        } else System.err.println("Girdiginiz ID ye ait kayit bulunamadi.");

    }while (sart);
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
                System.err.println("Yanlis deger girdiniz!!!");
                System.out.printf(ANSI_GREEN + "Lutfen tekrar giris yapiniz..." + ANSI_RESET);
                input.nextLine();       //Girdi bufferini temizleme
            }

            if (sec < 0) {
                System.err.println("Negatif deger girdiniz!!!");
                falseGir = true;
            }


        } while (!falseGir);

        return sec;

    }

    public double doubleHataliGiris() {
        boolean falseGir = false;
        double sec = 0;
        do {

            try {
                sec = input.nextDouble();
                input.nextLine();       //dummyCod
                falseGir = true;
            } catch (InputMismatchException e) {
                System.err.println("Yanlis deger girdiniz!!!");
                System.out.printf(ANSI_GREEN + "Lutfen tekrar giris yapiniz..." + ANSI_RESET);
                input.nextLine();       //Girdi bufferini temizleme
            }

            if (sec < 0) {
                System.err.println("Negatif deger girdiniz!!!");
                falseGir = true;
            }


        } while (!falseGir);

        return sec;

    }



}