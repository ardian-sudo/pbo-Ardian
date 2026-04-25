public class Bankbca extends Bank {

    // Override sukuBunga
    @Override
    public void sukuBunga() {
        System.out.println("Suku Bunga BCA adalah 4.5%");
    }

    // Override transferUang - bankTujuan otomatis "BCA"
    @Override
    public void transferUang(int jumlah, String rekeningTujuan, String bankTujuan) {
        bankTujuan = "BCA"; // Paksa bank tujuan = BCA
        int biaya = hitungBiaya(bankTujuan);
        System.out.println("[BankBCA] Transfer Rp" + jumlah + " ke rekening "
                + rekeningTujuan + " di Bank " + bankTujuan);
        System.out.println("Biaya transfer: Rp" + biaya);
        System.out.println("Total: Rp" + (jumlah + biaya));
        System.out.println("-------------------------------");
    }
}