package miniDepoProjesi;

import java.util.Scanner;

public class Runner {

    static {
        Service service =new Service();
        service.message("DEPOYA HOSGELDINIZ");

    }

    public static void anaMenu() {

        String ANSI_RESET = "\u001B[0m";
        String ANSI_YELLOW = "\u001B[33m";
        String ANSI_PURPLE = "\u001B[35m";

        System.out.println(ANSI_PURPLE + "Lutfen yapmak istediginiz islemi secin" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "╔════════════════════╗"+"╔════════════════════╗");
        System.out.println("║" + ANSI_PURPLE + "\t1 URUN TANIMLAMA " + ANSI_YELLOW + "║" +"║"+
                ANSI_PURPLE + "\t2   URUN LISTELE " + ANSI_YELLOW + "  ║");
        System.out.println("╚════════════════════╝" + "╚════════════════════╝");
        System.out.println(ANSI_YELLOW + "╔════════════════════╗"+"╔════════════════════╗");
        System.out.println("║" + ANSI_PURPLE + "\t3 URUN GIRIS     " + ANSI_YELLOW + "║" +"║"+
                ANSI_PURPLE + "\t4  URUN RAFA KOY " + ANSI_YELLOW + "  ║");
        System.out.println("╚════════════════════╝" + "╚════════════════════╝");
        System.out.println(ANSI_YELLOW + "╔════════════════════╗"+"╔════════════════════╗");
        System.out.println("║" + ANSI_PURPLE + "\t5 URUN CIKISI YAP" + ANSI_YELLOW + "║" +"║"+
                ANSI_PURPLE + "\t6     CIKIS      " + ANSI_YELLOW + "  ║");
        System.out.println("╚════════════════════╝" + "╚════════════════════╝");
        System.out.print(ANSI_PURPLE + "Bir seçenek girin (1-6):" + ANSI_RESET);
    }





    public static void main(String[] args) {

        Service service = new Service();

        Scanner input = new Scanner(System.in);
        boolean a = true;
        do {
            anaMenu();

            int sec = service.intHataliGiris(); //Switch'te int  disinda bir deger girilirse try catch kullandik.


            switch (sec) {
                case 1:
                    service.urunTanimla();
                    break;
                case 2:
                    service.urunListele();
                    break;
                case 3:
                    service.urunGir();
                    break;
                case 4:
                    service.urunuRafaKoy();
                    break;
                case 5:
                    service.urunCikisiYap();
                    break;
                case 6:
                    a =service.cikis();
                    break;
                default:
                    System.out.println("Uygun Bir deger giriniz..");

            }
        } while (a);
    }
}