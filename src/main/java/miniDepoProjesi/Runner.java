package miniDepoProjesi;

import java.util.Scanner;

public class Runner {

static{
    System.out.println("**********************************\n\t\tDEPOYA HOSGELDINIZ\t\t\t\n**********************************");
}

    public static void anaMenu() {

        System.out.println("\n Lutfen yapmak istediginiz islemi secin\n" +
                "\t1. Urun Tanimla\n \t2. Urun Listele \n\t3. Urun Giris" +
                "\n\t4. Urun Rafa Koy\n\t5. Urun Cikisi Yap\n\t6. Cikis  ");

    }


    public static void main(String[] args) {

        Service service = new Service();

        Scanner input = new Scanner(System.in);
        boolean a = true;
        do {
            anaMenu();
            int sec = input.nextInt();

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
                    //yanlis giris

            }
        } while (a);
    }
}
