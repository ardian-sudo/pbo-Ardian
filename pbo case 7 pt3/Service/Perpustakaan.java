package Service;

import java.util.ArrayList;

public class Perpustakaan<T> {        // Generic class
    private ArrayList<T> koleksi = new ArrayList<>();

    public void tambah(T item) {
        koleksi.add(item);
        System.out.println("Item ditambahkan ke koleksi.");
    }

    public void tampilSemua() {
        System.out.println("\n=== KOLEKSI PERPUSTAKAAN ===");
        for (T item : koleksi) {
            System.out.println(item);  // memanggil toString atau getInfo via polimorfisme
        }
    }

    public ArrayList<T> getKoleksi() { return koleksi; }
}