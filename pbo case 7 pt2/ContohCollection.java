import java.util.ArrayList;
import java.util.ArrayDeque;

public class ContohCollection {
    public static void main(String[] args) {

        // ── ArrayList ──────────────────────────────────────────
        ArrayList<String> matkul = new ArrayList<>();
        matkul.add("PBO");
        matkul.add("Algoritma");
        matkul.add("Basis Data");
        matkul.remove("Algoritma");         // hapus elemen
        System.out.println("ArrayList : " + matkul);
        System.out.println("Elemen ke-0: " + matkul.get(0));

        // ── ArrayDeque ─────────────────────────────────────────
        ArrayDeque<String> antrian = new ArrayDeque<>();
        antrian.addFirst("Mahasiswa A");    // tambah di depan
        antrian.addLast("Mahasiswa B");     // tambah di belakang
        antrian.addLast("Mahasiswa C");
        System.out.println("\nArrayDeque  : " + antrian);
        System.out.println("Peek depan  : " + antrian.peekFirst());
        System.out.println("Poll depan  : " + antrian.pollFirst()); // ambil & hapus
        System.out.println("Sisa deque  : " + antrian);
    }
}