package miniDepoProjesi;

import java.util.*;

public class Service extends Urun {


    Scanner input = new Scanner(System.in);
    HashMap<String, Urun> urunHm = new HashMap<>();

    public Service() {

    }

    void urunTanimla() throws InterruptedException {

        UUID uuid = UUID.randomUUID();
        String id = uuid.toString().substring(0, 5).toUpperCase();


        System.out.println("Lutfen urun ismini giriniz");

        String urunIsim = null;
        try {
            urunIsim = input.nextLine();
        } catch (InputMismatchException e) {
            Thread.sleep(1000);
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
            Thread.sleep(1000);
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
        System.out.printf(ANSI_BLUE + "| %-15s | %-20s | %-15s | %-15s | %-15s | %-15s %n" + ANSI_RESET, "ID NO", "URUN ISMI", "URETICI FIRMA", "URUN BIRIM", "MIKTAR", "RAF");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (Map.Entry<String, Urun> w : urunHm.entrySet()) {
            Urun urun = w.getValue();
            urun.getUrunIsmi();
            System.out.printf("| %-15s | %s%-20s%s | %s%-15s%s | %s%-15s%s | %s%-15s%s | %s%-15s%s %n",
                    w.getKey(), ANSI_GREEN, urun.getUrunIsmi(), ANSI_RESET, ANSI_GREEN, urun.getUretici(), ANSI_RESET, ANSI_GREEN, urun.getBirim(), ANSI_RESET, ANSI_RED, urun.getMiktar(), ANSI_RESET, ANSI_GREEN, urun.getRaf(), ANSI_RESET);
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
                    break;
                }
            }
        } else {
            System.err.println("ID bulunamadi. Lutfen gecerli bir ID giriniz..");
            urunGir();
        }

    }


    public void urunuRafaKoy() throws InterruptedException {
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
                        System.out.println("Urun " + urun.getRaf() + " rafina eklendi..");
                        Thread.sleep(1000);
                    } else {
                        System.err.println("Stokta urun mevcut degil.");
                        Thread.sleep(1000);
                    }
                }
            }
        } else {
            System.err.println("Girdiginiz ID ye ait kayit bulunamadi.");
            urunuRafaKoy();
        }
    }

    public void urunCikisiYap() throws InterruptedException {
        urunListele();
        boolean sart = true;
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
                            sart = false;
                            break;
                        } else {
                            System.err.println("Yeterli urun bulunmamaktadir.\nDepoda " + ANSI_RED + urun.getMiktar() + ANSI_RESET + " " + urun.getBirim() + " bulunmaktadir.");
                        }
                    }
                }
            } else System.err.println("Girdiginiz ID ye ait kayit bulunamadi.");

        } while (sart);
    }

    public boolean cikis() {
        boolean cikis;


        mesage("   Guncel liste   ");


        urunListele();


        System.out.println("Programda kalmak icin herhangi bir tusa basiniz\n" +
                "Cikmak icin Lutfen (Cikis) yaziniz!!");

        String s = input.nextLine().trim();

        if (s.equalsIgnoreCase("cikis")) {

            System.out.print(ANSI_YELLOW + "☻ Iyi Gunler Dileriz ☻" + ANSI_RESET + "\n Designed by ");

            karakterleriGetir();
            cikis = false;
        } else {
            cikis = true;
        }

        return cikis;
    }

    public void karakterleriGetir() {

        String MESAJ2 = ANSI_PURPLE + "  ♦  QA_09_Mentor_TEAM ™ ♦ " + ANSI_RESET;
        for (char c : MESAJ2.toCharArray()) {
            System.out.print(c);
            bekle(150);
        }
        System.out.println();
        bekle(150);


    }

    public void bekle(int millisaniye) {
        try {
            Thread.sleep(millisaniye);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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
                if (sec < 0) {
                    System.err.println("Negatif deger girdiniz!!!");

                    falseGir = true;
                    urunCikisiYap();
                }

                falseGir = true;
            } catch (InputMismatchException e) {
                System.err.println("Yanlis deger girdiniz!!!");
                System.out.printf(ANSI_GREEN + "Lutfen tekrar giris yapiniz..." + ANSI_RESET);

                input.nextLine();       //Girdi bufferini temizleme
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        } while (!falseGir);

        return sec;

    }

    public void mesage(String str) {
        System.out.println("\u001B[33m\n*******************************************\u001B[0m");
        System.out.printf("\u001B[36m*"); // Mavi renk
        System.out.printf("\u001B[31m*"); // Kırmızı renk
        System.out.printf("\u001B[33m*"); // Sarı renk
        System.out.printf("\u001B[32m*"); // Yeşil renk
        System.out.printf("\u001B[35m*"); // Mor renk
        System.out.printf("\u001B[34m*"); // Mavi renk
        System.out.printf("\u001B[37m*"); // Beyaz renk
        System.out.printf("\u001B[0m"); // Rengi sıfırla

        System.out.print("\u001B[33m\t☺\t" + str + "\t☺\t\u001B[0m");

        System.out.printf("\u001B[32m*"); // Yeşil renk
        System.out.printf("\u001B[35m*"); // Mor renk
        System.out.printf("\u001B[36m*"); // Mavi renk
        System.out.printf("\u001B[34m*"); // Mavi renk
        System.out.printf("\u001B[33m*"); // Sarı renk
        System.out.printf("\u001B[31m*"); // Kırmızı renk
        System.out.printf("\u001B[37m*"); // Beyaz renk
        System.out.printf("\u001B[0m"); // Rengi sıfırla

        System.out.println("\u001B[33m\n*******************************************\u001B[0m");
    }


}