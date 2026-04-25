
package Model;

public abstract class Item {
    private String judul;   // enkapsulasi: private
    private String kode;

    public Item(String kode, String judul) {
        this.kode  = kode;
        this.judul = judul;
    }

    // Getter
    public String getJudul() { return judul; }
    public String getKode()  { return kode; }

    // Abstract method → wajib di-override child class
    public abstract String getInfo();

    public String toString() {
    return getInfo(); // panggil getInfo() yang sudah ada
}
}