public class Bankbni extends Bank {

    // Override sukuBunga
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga BNI adalah 4%");
    }

    // Override transferUang - bankTujuan otomatis "BNI"
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BNI"; // Paksa bank tujuan = BNI
        int biaya = hitungBiaya(bankTujuan);
        System.out.println("[BankBNI] Transfer Rp" + jumlah + " ke rekening "
                + rekeningTujuan + " di Bank " + bankTujuan);
        System.out.println("Biaya transfer: Rp" + biaya);
        System.out.println("Total: Rp" + (jumlah + biaya));
        System.out.println("-------------------------------");
    }
}