import java.util.ArrayList;
import java.util.Scanner;

// CLASS INDUK (PARENT CLASS) : Mahasiswa
// Menyimpan data dasar mahasiswa: NIM dan Nama

class Mahasiswa {
    protected String nim;
    protected String nama;

    public Mahasiswa(String nim, String nama) {
        this.nim  = nim;
        this.nama = nama;
    }

    public String getNim()  { return nim; }
    public String getNama() { return nama; }
}

// CLASS ANAK (CHILD CLASS) : NilaiMahasiswa
// Mewarisi Mahasiswa dan menambahkan atribut nilai & grade

class NilaiMahasiswa extends Mahasiswa {
    private int nilai;
    private String grade;
    private boolean lulus;
    private boolean inputValid;

    // Constructor — memanggil constructor parent dengan super()
    public NilaiMahasiswa(String nim, String nama, int nilai) {
        super(nim, nama);   // <-- pewarisan: panggil constructor Mahasiswa
        this.nilai = nilai;
        tentukanGrade();
    }

    // Method untuk menentukan grade berdasarkan nilai
    private void tentukanGrade() {
        if (nilai < 0 || nilai > 100) {
            grade      = "?";
            lulus      = false;
            inputValid = false;
        } else {
            inputValid = true;
            if (nilai >= 80) {
                grade = "A"; lulus = true;
            } else if (nilai >= 70) {
                grade = "B"; lulus = true;
            } else if (nilai >= 60) {
                grade = "C"; lulus = true;
            } else if (nilai >= 50) {
                grade = "D"; lulus = false;
            } else {
                grade = "E"; lulus = false;
            }
        }
    }

    public int     getNilai()      { return nilai; }
    public String  getGrade()      { return grade; }
    public boolean isLulus()       { return lulus; }
    public boolean isInputValid()  { return inputValid; }

    // Method untuk menampilkan data satu mahasiswa
    public void tampilkan() {
        if (!inputValid) {
            System.out.println("NIM   : " + nim);
            System.out.println("Nama  : " + nama);
            System.out.println(">>> Input nilai anda salah <<<");
        } else {
            System.out.println("NIM   : " + nim);
            System.out.println("Nama  : " + nama);
            System.out.println("Nilai : " + nilai);
            System.out.println("Grade : " + grade);
        }
        System.out.println("========================================");
    }
}

// CLASS UTAMA : Main
// Berisi method main() — titik masuk program

public class Inheritance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<NilaiMahasiswa> daftarMahasiswa = new ArrayList<>();

        System.out.print("Masukkan jumlah mahasiswa: ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        // ---- Input data mahasiswa ----
        for (int i = 0; i < jumlah; i++) {
            System.out.println("\n--- Mahasiswa ke-" + (i + 1) + " ---");
            System.out.print("NIM   : ");
            String nim = sc.nextLine();
            System.out.print("Nama  : ");
            String nama = sc.nextLine();
            System.out.print("Nilai : ");
            int nilai = sc.nextInt();
            sc.nextLine();

            NilaiMahasiswa mhs = new NilaiMahasiswa(nim, nama, nilai);
            daftarMahasiswa.add(mhs);
        }

        // ---- Tampilkan data per mahasiswa ----
        System.out.println("\n========================================");
        System.out.println("          DATA NILAI MAHASISWA");
        System.out.println("========================================");
        for (NilaiMahasiswa mhs : daftarMahasiswa) {
            mhs.tampilkan();
        }

        // ---- Hitung statistik ----
        int totalNilai    = 0;
        int validCount    = 0;

        ArrayList<String> namaLulus     = new ArrayList<>();
        ArrayList<String> namaTidakLulus= new ArrayList<>();
        ArrayList<String> namaA         = new ArrayList<>();
        ArrayList<String> namaB         = new ArrayList<>();
        ArrayList<String> namaC         = new ArrayList<>();
        ArrayList<String> namaD         = new ArrayList<>();
        ArrayList<String> namaE         = new ArrayList<>();

        for (NilaiMahasiswa mhs : daftarMahasiswa) {
            if (!mhs.isInputValid()) continue;
            totalNilai += mhs.getNilai();
            validCount++;

            if (mhs.isLulus()) namaLulus.add(mhs.getNama());
            else               namaTidakLulus.add(mhs.getNama());

            switch (mhs.getGrade()) {
                case "A": namaA.add(mhs.getNama()); break;
                case "B": namaB.add(mhs.getNama()); break;
                case "C": namaC.add(mhs.getNama()); break;
                case "D": namaD.add(mhs.getNama()); break;
                case "E": namaE.add(mhs.getNama()); break;
            }
        }

        double rata = validCount > 0 ? (double) totalNilai / validCount : 0;

        // ---- Tampilkan ringkasan ----
        System.out.println("Jumlah Mahasiswa          : " + daftarMahasiswa.size());
        System.out.println("Jumlah Mahasiswa Lulus    : " + namaLulus.size()
                + (namaLulus.isEmpty() ? "" : " yaitu " + String.join(", ", namaLulus)));
        System.out.println("Jumlah Mahasiswa Tdk Lulus: " + namaTidakLulus.size()
                + (namaTidakLulus.isEmpty() ? "" : " yaitu " + String.join(", ", namaTidakLulus)));

        tampilGrade("A", namaA);
        tampilGrade("B", namaB);
        tampilGrade("C", namaC);
        tampilGrade("D", namaD);
        tampilGrade("E", namaE);

        // Buat string kalkulasi rata-rata
        StringBuilder kalkulasi = new StringBuilder();
        for (int i = 0; i < daftarMahasiswa.size(); i++) {
            NilaiMahasiswa mhs = daftarMahasiswa.get(i);
            if (!mhs.isInputValid()) continue;
            if (kalkulasi.length() > 0) kalkulasi.append("+");
            kalkulasi.append(mhs.getNilai());
        }
        System.out.printf("Rata-rata nilai mahasiswa : %s / %d = %.2f%n",
                kalkulasi, validCount, rata);

        sc.close();
    }

    // Helper: cetak baris grade hanya jika ada mahasiswa di grade tersebut
    static void tampilGrade(String grade, ArrayList<String> nama) {
        if (!nama.isEmpty()) {
            System.out.println("Jumlah Mahasiswa Grade " + grade + "  : "
                    + nama.size() + " yaitu " + String.join(", ", nama));
        }
    }
}