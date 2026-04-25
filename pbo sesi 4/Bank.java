public class Bank {

    // Method sukuBunga - bisa di-override oleh subclass
    public void sukuBunga() {
        System.out.println("Suku Bunga standar adalah 3%");
    }

    // Overload 1: Transfer ke rekening lain (same bank)
    public void transferUang(int jumlah, String rekeningTujuan) {
        int biaya = hitungBiaya("SAME");
        System.out.println("Transfer Rp" + jumlah + " ke rekening " + rekeningTujuan);
        System.out.println("Biaya transfer: Rp" + biaya);
        System.out.println("Total: Rp" + (jumlah + biaya));
        System.out.println("-------------------------------");
    }

    // Overload 2: Transfer ke bank lain
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        int biaya = hitungBiaya(bankTujuan);
        System.out.println("Transfer Rp" + jumlah + " ke rekening " + rekeningTujuan
                + " di Bank " + bankTujuan);
        System.out.println("Biaya transfer: Rp" + biaya);
        System.out.println("Total: Rp" + (jumlah + biaya));
        System.out.println("-------------------------------");
    }

    // Overload 3: Transfer ke bank lain + berita
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan, String berita) {
        int biaya = hitungBiaya(bankTujuan);
        System.out.println("Transfer Rp" + jumlah + " ke rekening " + rekeningTujuan
                + " di Bank " + bankTujuan);
        System.out.println("Berita: " + berita);
        System.out.println("Biaya transfer: Rp" + biaya);
        System.out.println("Total: Rp" + (jumlah + biaya));
        System.out.println("-------------------------------");
    }

    // BONUS: Hitung biaya berdasarkan bank tujuan
    public int hitungBiaya(String bankTujuan) {
        switch (bankTujuan.toUpperCase()) {
            case "SAME":  return 0;       // Sesama bank, gratis
            case "BNI":   return 6500;
            case "BCA":   return 6500;
            default:      return 15000;   // Bank lain (BI-FAST / SKN)
        }
    }
}