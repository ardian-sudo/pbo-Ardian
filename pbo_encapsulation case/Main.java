import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("   SIMULASI PROGRAM ENCAPSULATION PBO   ");
        System.out.println("========================================\n");

        // ===== INPUT DATA MAHASISWA =====
        System.out.println("--- Input Data Mahasiswa ---");
        System.out.print("Nama Mahasiswa : ");
        String namaMhs = scanner.nextLine();

        System.out.print("Alamat Mahasiswa : ");
        String alamatMhs = scanner.nextLine();

        Student mahasiswa = new Student(namaMhs, alamatMhs);
        System.out.println("Data mahasiswa berhasil dibuat: " + mahasiswa);

        // Input mata kuliah dan nilai mahasiswa
        System.out.print("\nBerapa mata kuliah yang ingin diinputkan? ");
        int jumlahMatkul = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < jumlahMatkul; i++) {
            System.out.print("Nama Mata Kuliah ke-" + (i + 1) + " : ");
            String matkul = scanner.nextLine();
            System.out.print("Nilai untuk " + matkul + " : ");
            int nilai = Integer.parseInt(scanner.nextLine());
            mahasiswa.addCourseGrade(matkul, nilai);
        }

        // Tampilkan nilai mahasiswa
        System.out.println();
        mahasiswa.printGrades();

        System.out.println();

        // ===== INPUT DATA DOSEN =====
        System.out.println("--- Input Data Dosen ---");
        System.out.print("Nama Dosen : ");
        String namaDosen = scanner.nextLine();

        System.out.print("Alamat Dosen : ");
        String alamatDosen = scanner.nextLine();

        Teacher dosen = new Teacher(namaDosen, alamatDosen);
        System.out.println("Data dosen berhasil dibuat: " + dosen);

        // Input mata kuliah yang diampu dosen
        System.out.print("\nBerapa mata kuliah yang diampu dosen? ");
        int jumlahMatkulDosen = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < jumlahMatkulDosen; i++) {
            System.out.print("Nama Mata Kuliah ke-" + (i + 1) + " : ");
            String matkul = scanner.nextLine();
            dosen.addCourse(matkul);
        }

        // Coba hapus satu mata kuliah
        System.out.print("\nMata kuliah mana yang ingin dihapus dari dosen? ");
        String hapusMatkul = scanner.nextLine();
        dosen.removeCourse(hapusMatkul);

        // Coba tambah mata kuliah yang sudah ada (test return false)
        System.out.print("Coba tambahkan mata kuliah yang sudah ada (test duplikat): ");
        String duplikat = scanner.nextLine();
        dosen.addCourse(duplikat);

        // Update alamat dosen
        System.out.print("\nUpdate alamat dosen baru: ");
        String alamatBaru = scanner.nextLine();
        dosen.setAddress(alamatBaru);
        System.out.println("Alamat diperbarui. Info dosen: " + dosen);

        // Tampilkan daftar matkul dosen
        System.out.println();
        System.out.println(dosen.tpString());

        System.out.println("========================================");
        System.out.println("          SIMULASI SELESAI              ");
        System.out.println("========================================");

        scanner.close();
    }
}
