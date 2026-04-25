package Model;
import Interfaces.Dipinjam;

public class Buku extends Item implements Dipinjam {
    private String penulis;
    private boolean tersedia = true;
    private String peminjam;

    public Buku(String kode, String judul, String penulis) {
        super(kode, judul);   // memanggil constructor parent
        this.penulis = penulis;
    }

    @Override
    public String getInfo() {   // polimorfisme
        return "[BUKU] " + getKode() + " | " + getJudul() + " - " + penulis;
    }

    @Override
    public void pinjam(String namaPeminjam) {
        if (tersedia) {
            tersedia = false;
            peminjam = namaPeminjam;
            System.out.println(getJudul() + " dipinjam oleh " + namaPeminjam);
        } else {
            System.out.println(getJudul() + " sedang tidak tersedia!");
        }
    }

    @Override
    public void kembalikan() {
        tersedia = true;
        System.out.println(getJudul() + " telah dikembalikan oleh " + peminjam);
        peminjam = null;
    }

    @Override
    public boolean isTersedia() { return tersedia; }
}