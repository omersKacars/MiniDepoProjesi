package depo;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        UrunIslemler u = new UrunIslemler();
        boolean t =true;

        do {
        System.out.println("Depomuza hosgeldiniz\n" +
                "ISLEM SECINIZ\n" +
                "1-     URUN TANIMLAMA\n" +
                "2-     URUN LISTELE\n" +
                "3-     URUN GIRISI\n" +
                "4-     URUNU RAFA KOY\n" +
                "5-     URUN LISTELEME\n" +
                "6-     CIKIS");

        int secenek = input.nextInt();
        input.nextLine();





        switch (secenek) {

            case 1:
                u.urunTanimlama();
                break;
            case 2:
                u.urunListele();
                break;
            case 3:
                u.urunGirisi();
                break;
            case 4:
                u.urunuRafaKoy();
                break;
            case 5:
                u.urunListele();
                break;
            case 6:
                t=false;


        }
    }while(t);

    }
}
