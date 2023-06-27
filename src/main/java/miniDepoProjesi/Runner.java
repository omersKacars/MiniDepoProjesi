package miniDepoProjesi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {






        static {
            System.out.println("\u001B[33m\n*******************************************\u001B[0m");
            System.out.printf("\u001B[36m*"); // Mavi renk
            System.out.printf("\u001B[31m*"); // Kırmızı renk
            System.out.printf("\u001B[33m*"); // Sarı renk
            System.out.printf("\u001B[32m*"); // Yeşil renk
            System.out.printf("\u001B[35m*"); // Mor renk
            System.out.printf("\u001B[34m*"); // Mavi renk
            System.out.printf("\u001B[37m*"); // Beyaz renk
            System.out.printf("\u001B[0m"); // Rengi sıfırla

            System.out.print("\u001B[33m\t☺\tDEPOYA HOSGELDINIZ\t☺\t\u001B[0m");

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

    public static void anaMenu() {

        System.out.printf("\n \u001B[36mLutfen yapmak istediginiz islemi secin\u001B[0m\n" +
                        "\t\u001B[32m%-2s\u001B[0m \u001B[35m%-18s\u001B[0m\n" +
                        "\t\u001B[32m%-2s\u001B[0m \u001B[35m%-18s\u001B[0m\n" +
                        "\t\u001B[32m%-2s\u001B[0m \u001B[35m%-18s\u001B[0m\n" +
                        "\t\u001B[32m%-2s\u001B[0m \u001B[35m%-18s\u001B[0m\n" +
                        "\t\u001B[32m%-2s\u001B[0m \u001B[35m%-18s\u001B[0m\n" +
                        "\t\u001B[32m%-2s\u001B[0m \u001B[35m%-18s\u001B[0m\n",
                "1.", "Urun Tanimla",
                "2.", "Urun Listele",
                "3.", "Urun Giris",
                "4.", "Urun Rafa Koy",
                "5.", "Urun Cikisi Yap",
                "6.", "Cikis");


    }


    public static void main(String[] args) {

        Service service = new Service();

        Scanner input = new Scanner(System.in);
        boolean a = true;
        do {
            anaMenu();

            int sec = service.intHataliGiris();


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
                    //cikis
                    a = false;
                    break;
                default:
                    System.out.println("Uygun Bir deger giriniz..");

            }
        } while (a);
    }
}