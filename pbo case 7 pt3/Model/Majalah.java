package Model;

public class Majalah extends Item {
    private int edisi;

    public Majalah(String kode, String judul, int edisi) {
        super(kode, judul);
        this.edisi = edisi;
    }

    @Override
    public String getInfo() {   // polimorfisme
        return "[MAJALAH] " + getKode() + " | " + getJudul() + " Edisi-" + edisi;
    }
}