import Model.Buku;
import Model.Majalah;
import Model.Item;
import Service.Perpustakaan;

public class Main {
    public static void main(String[] args) {

        // Generic Perpustakaan dengan tipe Item
        Perpustakaan<Item> perpus = new Perpustakaan<>();

        Buku b1 = new Buku("B001", "Clean Code", "Robert C. Martin");
        Buku b2 = new Buku("B002", "Design Patterns", "Gang of Four");
        Majalah m1 = new Majalah("M001", "National Geographic", 215);

        perpus.tambah(b1);
        perpus.tambah(b2);
        perpus.tambah(m1);

        // Polimorfisme: getInfo() dipanggil sesuai tipe objek
        perpus.tampilSemua();

        // Fitur pinjam/kembalikan (via interface Dipinjam)
        System.out.println("\n=== TRANSAKSI PEMINJAMAN ===");
        b1.pinjam("Ferdi");
        b1.pinjam("Budi");   // gagal, sedang dipinjam
        b1.kembalikan();
        b1.pinjam("Budi");   // berhasil
    }
}