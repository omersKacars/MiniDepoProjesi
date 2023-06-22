package miniDepoProjesi;

public class Service extends Urun {

    public Service(String id, String urunIsmi, String uretici, double miktar, String birim, String raf) {
        super(id, urunIsmi, uretici, miktar, birim, raf);
    }

    public Service() {

    }


    public void urunTanimla(){
        System.out.println("urun tanimlandi..");
    }


    public void urunListele(){
        System.out.println("urun listelendi");
    }


    public void urunGir(){

    }


    public void urunuRafaKoy(){

    }


    public void urunCikisiYap(){

    }

}
