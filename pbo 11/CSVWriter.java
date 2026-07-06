import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CSVWriter {
    public static void main(String[] args) {
        String csvFile = "D:\\new_students.csv";

        // Menggunakan Scanner untuk menerima input dari user
        try (Scanner scanner = new Scanner(System.in);
                BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            // Note: 'true' di FileWriter digunakan agar data baru di-append (ditambahkan di
            // bawah), bukan menimpa file lama

            System.out.print("Masukkan jumlah mahasiswa yang ingin diinput: ");
            int jumlah = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi sisa newline

            for (int i = 0; i < jumlah; i++) {
                System.out.println("\nData Mahasiswa ke-" + (i + 1));
                System.out.print("NIM   : ");
                String nim = scanner.nextLine();
                System.out.print("Nama  : ");
                String nama = scanner.nextLine();
                System.out.print("Umur  : ");
                String umur = scanner.nextLine();
                System.out.print("Prodi : ");
                String prodi = scanner.nextLine();

                // Gabungkan data menjadi format CSV
                String line = nim + ", " + nama + ", " + umur + ", " + prodi;

                // Tulis ke file
                bw.write(line);
                bw.newLine();
            }

            System.out.println("\nData berhasil disimpan ke " + csvFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}