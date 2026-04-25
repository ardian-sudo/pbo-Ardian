public class Main {
    public static void main(String[] args) {

        System.out.println("===== BANK (BASE CLASS) =====");
        Bank bank = new Bank();
        bank.sukuBunga();
        System.out.println();

        // Method Overloading
        System.out.println("-- Overload 1: Transfer sesama bank --");
        bank.transferUang(500000, "1234567890");

        System.out.println("-- Overload 2: Transfer ke bank lain --");
        bank.transferUang(1000000, "0987654321", "Mandiri");

        System.out.println("-- Overload 3: Transfer dengan berita --");
        bank.transferUang(750000, "1122334455", "BRI", "Pembayaran kos bulan Mei");

        // ---- BankBNI ----
        System.out.println("\n===== BANK BNI (SUBCLASS) =====");
        Bankbni bni = new Bankbni();
        bni.sukuBunga(); // Override
        System.out.println();

        System.out.println("-- Transfer via BNI (bankTujuan otomatis BNI) --");
        bni.transferUang(2000000, "5566778899", "apa saja"); // bankTujuan di-override jadi BNI

        System.out.println("-- Transfer BNI dengan berita (pakai overload dari Bank) --");
        bni.transferUang(300000, "5566778899", "BNI", "Cicilan motor");

        // ---- BankBCA ----
        System.out.println("\n===== BANK BCA (SUBCLASS) =====");
        Bankbca bca = new Bankbca();
        bca.sukuBunga(); // Override
        System.out.println();

        System.out.println("-- Transfer via BCA (bankTujuan otomatis BCA) --");
        bca.transferUang(5000000, "9988776655", "apa saja"); // bankTujuan di-override jadi BCA

        System.out.println("-- Transfer BCA dengan berita (pakai overload dari Bank) --");
        bca.transferUang(100000, "9988776655", "BCA", "Bayar langganan Netflix");

        // ---- Polimorfisme: referensi Bank menunjuk subclass ----
        System.out.println("\n===== POLIMORFISME =====");
        Bank[] banks = { new Bank(), new Bankbni(), new Bankbca() };
        for (Bank b : banks) {
            b.sukuBunga(); // Memanggil versi yang sesuai (polymorphism)
        }
    }
}