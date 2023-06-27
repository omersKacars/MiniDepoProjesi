package miniDepoProjesi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Runner {

        static {
           Service service =new Service();
           service.mesage("DEPOYA HOSGELDINIZ");

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


    public static void main(String[] args) throws InterruptedException {

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
                    a =service.cikis();
                    break;
                default:
                    System.out.println("Uygun Bir deger giriniz..");

            }
        } while (a);
    }
}