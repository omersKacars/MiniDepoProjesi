package miniDepoProjesi;

public class Urun {



   private String id ;
   private String urunIsmi;
   private String uretici;
   private double miktar;
   private String birim;
   private String raf;

    public Urun(String urunIsmi, String uretici, double miktar, String birim, String raf) {

        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktar = miktar;
        this.birim = birim;
        this.raf = raf;

    }

    public String ANSI_RESET = "\u001B[0m";
    public String ANSI_BOLD = "\u001B[1m";
    public String ANSI_UNDERLINE = "\u001B[4m";


    public String ANSI_BLACK = "\u001B[30m";
    public String ANSI_RED = "\u001B[31m";
    public String ANSI_GREEN = "\u001B[32m";
    public String ANSI_YELLOW = "\u001B[33m";
    public String ANSI_BLUE = "\u001B[34m";
    public String ANSI_PURPLE = "\u001B[35m";
    public String ANSI_CYAN = "\u001B[36m";
    public String ANSI_WHITE = "\u001B[37m";


    public Urun() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public double getMiktar() {
        return miktar;
    }

    public void setMiktar(double miktar) {
        this.miktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    @Override
    public String toString() {
        return "Urun{" +
                ", urunIsmi='" + urunIsmi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", miktar=" + miktar +
                ", birim='" + birim + '\'' +
                ", raf='" + raf + '\'' +
                '}';
    }
}
